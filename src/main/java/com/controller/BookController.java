package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Book;

import com.service.BookService;


@RestController
@RequestMapping("/v3")
public class BookController {
	
	@Autowired
	BookService bookservice;

	@GetMapping("/books") // localhost:999/v3/books
	ResponseEntity<List<Book>> fetchAllBooks() {

		List<Book> bookList = bookservice.getAllBooks();

		return new ResponseEntity<>(bookList, HttpStatus.OK);

	}

	@GetMapping("/book/{id}")//localhost:999/v3/book/2
	ResponseEntity<?> fetchBookbyId(@PathVariable int id){	
		
		Book book = bookservice.getBookbyId(id);
		if (book != null) {

			return new ResponseEntity<>(book, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("this book does not exist", HttpStatus.OK); // ok==200

		}
}
	
	@PostMapping("/books")
	ResponseEntity<String> registerBook(@RequestBody Book book){
		bookservice.createBook(book);
		return new ResponseEntity<>("book registered successfully",HttpStatus.CREATED);//created=201	
		
	}
	
	@PutMapping("/book")
	ResponseEntity<String> updateBook(@RequestBody Book book){
		bookservice.updateBook(book);
		return new ResponseEntity<>("book updated successfully",HttpStatus.CREATED);//created=201	
		
	}
	
	@DeleteMapping("/book/{id}")
	ResponseEntity<String> deleteBook(@PathVariable int id){
		bookservice.deleteBook(id);
		return new ResponseEntity<>("book deleted successfully",HttpStatus.NO_CONTENT);//created=201	
		
	}
	

}
