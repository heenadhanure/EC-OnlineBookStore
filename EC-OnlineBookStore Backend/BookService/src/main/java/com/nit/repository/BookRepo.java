package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

	void deleteByBookTitle(String bookTitle);

	Book findByBookTitle(String bookTitle);

}
