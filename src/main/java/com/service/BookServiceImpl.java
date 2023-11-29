package com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.entity.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao bookdao;

	@Override
	public void createBook(Book book) {
		bookdao.save(book);
		
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> listBooks = bookdao.findAll();
		return listBooks;
	}


	@Override
	public void deleteBook(int bookId) {
		bookdao.deleteById(bookId);
		
	}

	@Override
	public Book getBookbyId(int id) {
		Optional<Book> book = bookdao.findById(id);
		return book.get();
	}

	@Override
	public void updateBook(Book book) {
		bookdao.save(book);
	}

}
