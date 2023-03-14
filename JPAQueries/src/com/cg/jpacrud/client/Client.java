package com.cg.jpacrud.client;

import com.cg.jpacrud.entities.Book;
import com.cg.jpacrud.service.BookService;
import com.cg.jpacrud.service.BookServiceImpl;

public class Client {

	public static void main(String[] args) {

		BookService service = new BookServiceImpl();
				
		System.out.println("************Listing total number of books*************");
		System.out.println("Total books:"+service.getBookCount());
		
		System.out.println("************Listing book with id 1*************");
		System.out.println("Book with ID 1:"+service.getBookById(1));
		
		System.out.println("************Listing All books*************");
		for(Book book:service.getAllBooks()) {
			System.out.println(book);
		}
		
		System.out.println("************Listing book written by Abdul Kalam*************");
		for(Book book:service.getAuthorBooks("apj abdul kalam") ) {
			System.out.println(book);
		}
		
		System.out.println("************Listing book on Java*************");
		for(Book book:service.getBookByTitle("here there and everywhere")) {
			System.out.println(book);
		}
			
		System.out.println("************Listing All books between 500 and 600*************");
		for(Book book:service.getBooksInPriceRange(100, 300) ) {
			System.out.println(book);
		}		

	}
}

