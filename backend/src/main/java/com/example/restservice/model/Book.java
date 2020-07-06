package com.example.restservice.model;

public class Book {

    private final long id;
    private String title;
    private Author author;
    private String isbn;

    public Book(long id, String title, Author author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Book(long id) {
        this.id = id;
    }


}
