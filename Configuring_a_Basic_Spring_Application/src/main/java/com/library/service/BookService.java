package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayLibrarySummary() {
        String title = bookRepository.getRecommendedBookTitle();
        int availableCopies = bookRepository.getAvailableCopies(title);

        System.out.println("Recommended book: " + title);
        System.out.println("Available copies: " + availableCopies);
    }
}