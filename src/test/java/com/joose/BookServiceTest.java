package com.joose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BookServiceTest {
	@Mock
	private BookRepository bookRepository;
	private BookService bookService;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		bookService = new BookService(bookRepository);
	}
	
	@Test
	void testAddBook() {
		Book book = new Book("Discrete Mathematics Simplified", "Pawan Kumar", "12");
		bookService.addBook(book);
		verify(bookRepository).addBook(book);
	}
	
	@Test
	void testGetBookByIsbn() {
		String isbn = "12";
		Book expectedBook = new Book("Discret Mathematics Simplified", "Pawan Kumar", isbn);
		when(bookRepository.getBookByIsbn(isbn)).thenReturn(expectedBook);
		
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
		when(bookRepository.getAllBooks()).thenReturn(expectedBooks);
		
		List<Book> actualBooks = bookService.getAllBooks();
		assertEquals(expectedBooks, actualBooks);
	}
}









































