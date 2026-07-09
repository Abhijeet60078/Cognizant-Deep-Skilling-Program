package com.library.repository;

public class BookRepository {

    public String findBookTitle() {
        return "Refactoring";
    }

    public int getStockCount(String bookTitle) {
        return 5;
    }
}