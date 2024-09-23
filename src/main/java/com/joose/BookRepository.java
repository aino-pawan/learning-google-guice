package com.joose;

import java.util.List;

public interface BookRepository {
	void addBook(Book book);
	Book getBookByIsbn(String isbn);
	List<Book> getAllBooks();
}