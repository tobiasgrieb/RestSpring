package com.example.restservice.dao;

import com.example.restservice.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorDao {

    int insertAuthor(UUID id, Author author);

    default int insertAuthor(Author author) {
        UUID id = UUID.randomUUID();
        return insertAuthor(id, author);
    }

    List<Author> selectAllAuthors();

    Optional<Author> selectAuthorById(UUID id);

    int deleteAuthorById(UUID id);

    int updateAuthorById(UUID id, Author author);

}

