package com.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.models.Book;
import com.services.BookService;


@RestController
public class BooksApi {
	private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
//    GET
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
//  GET one
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
	    Book book = bookService.findBook(id);
	    return book;
  }
    
//    POST
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, 
    					@RequestParam(value="description") String desc, 
    					@RequestParam(value="language") String lang, 
    					@RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
//    PUT/UPDATE
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id,
    				   @RequestParam(value="title") String title,
    				   @RequestParam(value="description") String desc, 
    				   @RequestParam(value="language") String lang, 
    				   @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
//    DELETE
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
   
    
//    END
}