package com.nit.service;

import java.util.List;

import com.nit.entity.Book;
import com.nit.model.BookDto;

public interface BookService {

	Book createOrUpdateBook(BookDto bookDto);

	Book getById(Long id);

	List<Book> retrieveAllBooks();

	Book getByTitle(String bookTitle);

	void deleteByBookId(Long id);

	void deleteByBookTitle(String bookTitle);


}
