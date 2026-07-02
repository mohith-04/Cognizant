package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerNewBook(String title) {
        System.out.println("Processing business logic for: " + title);
        bookRepository.saveBook(title);
    }
}