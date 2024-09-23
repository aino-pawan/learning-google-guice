package com.joose;

import com.google.inject.AbstractModule;

public class BookManagementModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(BookRepository.class).to(InMemoryBookRepository.class);
	}
}