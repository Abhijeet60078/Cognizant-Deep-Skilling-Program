package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showBookDetails() {
        String bookTitle = bookRepository.findBookTitle();
        int stockCount = bookRepository.getStockCount(bookTitle);

        System.out.println("Book title: " + bookTitle);
        System.out.println("Stock count: " + stockCount);
    }
}