package com.nit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.entity.Book;
import com.nit.entity.mongo.BookMongo;
import com.nit.exceptions.BookNotFoundException;
import com.nit.model.BookDto;
import com.nit.repository.BookRepo;
import com.nit.repository.mongo.BookMongoRepo;
import com.nit.service.BookService;

@Service	
public class BookServiceImpl implements BookService{

	public static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private BookMongoRepo bookMongoRepo;
	
	@Override
	@Cacheable(value = "createBook")
	public Book createOrUpdateBook(BookDto bookDto) {
		logger.info("BookServiceImpl saveBook() calling");
		Book book = new Book();
		BookMongo bookMongo = new BookMongo();
		
		if(bookDto.getBookId()==null) {
			book.setBookTitle(bookDto.getBookTitle());
			book.setBookAuthor(bookDto.getBookAuthor());
			book.setBookPublisher(bookDto.getBookPublisher());
			book.setBookPrice(bookDto.getBookPrice());
//			System.err.println("Check how many times record inserted in the DB-Table");
			bookRepo.save(book);
			
			bookMongo.setBookTitle(bookDto.getBookTitle());
			bookMongo.setBookAuthor(bookDto.getBookAuthor());
			bookMongo.setBookPublisher(bookDto.getBookPublisher());
			bookMongo.setBookPrice(bookDto.getBookPrice());
//			System.err.println("Check how many times record inserted in the DB-Table");
			bookMongoRepo.save(bookMongo);
			
			logger.debug("New book getting saved : ",bookDto);
		}else {
			Optional<Book> book1 = bookRepo.findById(bookDto.getBookId());
			if(book1.isPresent()) {
				book = book1.get();
				book.setBookTitle(bookDto.getBookTitle());
				book.setBookAuthor(bookDto.getBookAuthor());
				book.setBookPublisher(bookDto.getBookPublisher());
				book.setBookPrice(bookDto.getBookPrice());
				
				logger.debug("Existing book getting updated : ",book);
			
				bookRepo.save(book);	
				
				bookMongo.setBookTitle(bookDto.getBookTitle());
				bookMongo.setBookAuthor(bookDto.getBookAuthor());
				bookMongo.setBookPublisher(bookDto.getBookPublisher());
				bookMongo.setBookPrice(bookDto.getBookPrice());
//				System.err.println("Check how many times record inserted in the DB-Table");
				bookMongoRepo.save(bookMongo);
			}else {
				logger.warn("Try seraching with valid Book Id");
				logger.warn("Try seraching with valid Book Id");
				logger.error("The book with given id is not present in the database");	
				throw new BookNotFoundException("Book Id Not Found");
			}
		}
		logger.info("BookServiceImpl saveBook() stopped");
		return book;
	}

	@Override
	@Cacheable(cacheNames="bookModule",key="#id")
	public Book getById(Long id) {
		logger.info("BookServiceImpl getById() calling");
		Optional<Book> byId = bookRepo.findById(id);
		if(!byId.isPresent()) {
			logger.warn("Try seraching with valid Book Id");
			logger.error("The book with given id is not present in the database");
			throw new BookNotFoundException("Book Not Found");
		}else {
			logger.info("BookServiceImpl getById() stopped");
			logger.debug("Book id found with the data : ",byId.getClass());
			return byId.get();
		}
		
	}

	@Override
	@Cacheable(value = "retriveAllBooks")
	public List<Book> retrieveAllBooks() {
		logger.info("BookServiceImpl retrieveAllBooks() calling");
		List<Book> allBooks = bookRepo.findAll();
		if(allBooks==null) {
			throw new BookNotFoundException("DB is Empty");
		}
		logger.info("BookServiceImpl retrieveAllBooks() stopped");
		return allBooks; 
	}

	@Override
	public void deleteByBookId(Long id) {
		logger.info("BookServiceImpl deleteById() calling");
		if(bookRepo.findById(id).isPresent())
			bookRepo.deleteById(id);
		else
			throw new BookNotFoundException("Book id not found");
		logger.info("BookServiceImpl deleteById() stopped");
	}

	@Override
	public Book getByTitle(String bookTitle) {
		logger.info("BookServiceImpl getByTitle() calling");
		Book book = bookRepo.findByBookTitle(bookTitle);
		if(book==null)
			throw new BookNotFoundException("Book Title Not Found...");
		logger.info("BookServiceImpl getByTitle() stopped");
		
		return book;
	}

	@Transactional
	@Override
	public void deleteByBookTitle(String bookTitle) {
		Book book = bookRepo.findByBookTitle(bookTitle);
		if(book!=null) {
//			System.out.println("Book data fetched by title : "+book);
			bookRepo.deleteByBookTitle(bookTitle);
		}else
			throw new BookNotFoundException("Book Title Not Found");
	}

}
