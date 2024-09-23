package com.joose;

import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new BookManagementModule());
		BookService bookService = injector.getInstance(BookService.class);
		
		Book book0 = new Book("Programming in Java", "Pawan Kumar", "12345");
		bookService.addBook(book0);
		System.out.println("Book addded: " + book0);
		
		Book book1 = new Book("Programming in Javascript", "Pawan Kumar", "67890");
		bookService.addBook(book1);
		System.out.println("Book addded: " + book1);
		
		Book jsBook = bookService.getBookByIsbn("67890");
		System.out.println("Received a book: " + jsBook);
		
		List<Book> books = bookService.getAllBooks();
		System.out.println("Fetch all the books");
		
		for (Book book: books) {
			System.out.println(book);
		}
	}
}