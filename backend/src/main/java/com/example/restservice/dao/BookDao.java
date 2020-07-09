package com.example.restservice.dao;

import com.example.restservice.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {

    int insertBook(Book book);

    List<Book> selectAllBooks();

    Optional<Book> selectBookById(UUID id);

    int deleteBookById(UUID id);

    int updateBookById(UUID id, Book book);

}

