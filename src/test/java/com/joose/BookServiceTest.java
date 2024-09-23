package com.joose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;

class BookServiceTest {
	@Mocked
	private BookRepository bookRepository;
	private BookService bookService;
	
	@BeforeEach
	void setup() {
		bookService = new BookService(bookRepository);
	}
	
	@Test
	void testAddBook() {
		Book book = new Book("Discrete Mathematics Simplified", "Pawan Kumar", "12");
		bookService.addBook(book);
		
		new Verifications() {{
			bookRepository.addBook(book);
			times = 1;
		}};
	}
	
	@Test
	void testGetBookByIsbn() {
		String isbn = "12";
		Book expectedBook = new Book("Discret Mathematics Simplified", "Pawan Kumar", isbn);
		
		new Expectations() {{
			bookRepository.getBookByIsbn(isbn);
			result = expectedBook;
		}};
		
		Book actualBook = bookService.getBookByIsbn(isbn);
		assertEquals(expectedBook, actualBook);
	}
	
	@Test
	void testGetAllBooks() {
		Book expectedBook1 = new Book("Discret Mathematics Simplified", "Pawan Kumar", "1201");
		Book expectedBook2 = new Book("Discret Mathematics Simplified", "Pawan Kumar", "1202");
		List<Book> expectedBooks = new ArrayList<>();
		expectedBooks.add(expectedBook1);
		expectedBooks.add(expectedBook2);
		
		new Expectations() {{
			bookRepository.getAllBooks();
			result = expectedBooks;
		}};
		
		List<Book> actualBooks = bookService.getAllBooks();
		assertEquals(expectedBooks, actualBooks);
	}
}