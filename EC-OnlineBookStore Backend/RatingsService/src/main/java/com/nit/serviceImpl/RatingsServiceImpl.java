package com.nit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Book;
import com.nit.entity.Customer;
import com.nit.entity.Ratings;
import com.nit.exceptions.BookNotFoundException;
import com.nit.exceptions.CustomerIdNotFoundException;
import com.nit.model.RatingsDto;
import com.nit.repository.BookRepo;
import com.nit.repository.CustomerRepo;
import com.nit.repository.RatingsRepository;
import com.nit.service.RatingsService;

@Service
public class RatingsServiceImpl implements RatingsService{
	@Autowired
	private CustomerRepo customerRepository;
	
	@Autowired
	private BookRepo bookRepository;
	
	@Autowired
	private RatingsRepository ratingsRepository;
	
	@Override
	public Ratings createRatingRivews(RatingsDto ratingsDto) {
	//  Step 1: Check if customer exists in DB using ID
	    // If not found, throw custom exception "Customer Id Not Found"
	    Customer customer = customerRepository.findById(ratingsDto.getCusmerId())
	        .orElseThrow(() -> new CustomerIdNotFoundException("Custmer Id Not found"));
	    
	    
	    //  Step 2: Check if book exists in DB using ID
	    // If not found, throw custom exception "Book Id not Found"
	    Book book = bookRepository.findById(ratingsDto.getBookId())
	        .orElseThrow(() -> new BookNotFoundException("Book Id not Found"));
	    
	    Ratings rating = new Ratings();
	    rating.setBook(book);
	    rating.setCustomer(customer);
	    rating.setRate(ratingsDto.getRate());
	    rating.setReviewText(ratingsDto.getReviewText());
	    ratingsRepository.save(rating);
		return rating;
	}

	@Override
	public List<Ratings> getByAllReview() {
		return ratingsRepository.findAll();
	}

//	@Override
//	public List<Ratings> getByBookId(Long id) {
//			
//		return ratingsRepository.findByBookId(id);
//	}
}
