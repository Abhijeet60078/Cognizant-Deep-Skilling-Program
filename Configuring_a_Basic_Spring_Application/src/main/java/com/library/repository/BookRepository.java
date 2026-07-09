package com.library.repository;

public class BookRepository {

    public String getRecommendedBookTitle() {
        return "Clean Code";
    }

    public int getAvailableCopies(String title) {
        return 3;
    }
}