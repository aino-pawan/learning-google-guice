package com.joose;

import java.util.List;

import com.google.inject.Inject;

public class BookService {
	private final BookRepository repository;
	
	@Inject
	public BookService(BookRepository repository) {
		this.repository = repository;
	}
	
	public void addBook(Book book) {
		repository.addBook(book);
	}
	
	public Book getBookByIsbn(String isbn) {
		return repository.getBookByIsbn(isbn);
	}
	
	public List<Book> getAllBooks() {
		return repository.getAllBooks();
	}
}