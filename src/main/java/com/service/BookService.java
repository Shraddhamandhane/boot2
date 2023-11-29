package com.service;

import java.util.List;

import com.entity.Book;


public interface BookService {

	void createBook(Book book);

	List<Book> getAllBooks();

	void deleteBook(int bookId);

	Book getBookbyId(int id);
	
	void updateBook(Book book);
	
	
	
	

	

	
	

	

}
