package com.example.restservice.business;

import com.example.restservice.persistence.BookModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {

    int insertBook(BookModel book);

    List<BookModel> selectAllBooks();

    Optional<BookModel> selectBookById(UUID id);

    int deleteBookById(UUID id);

}

