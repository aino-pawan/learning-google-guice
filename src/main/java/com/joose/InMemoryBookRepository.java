package com.joose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {
	private final Map<String, Book> books;
	
	public InMemoryBookRepository() {
		this.books = new HashMap<>();
	}

	@Override
	public void addBook(Book book) {
		books.put(book.getIsbn(), book);
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return books.get(isbn);
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<>(books.values());
	}
}