package com.example.restservice.service;

import com.example.restservice.dao.AuthorDao;
import com.example.restservice.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorService(@Qualifier("fake") AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public int addAuthor(Author author) {
        return authorDao.insertAuthor(author);
    }

    public List<Author> getAllAuthors() {
        return authorDao.selectAllAuthors();
    }

    public Optional<Author> getAuthorById(UUID id) {
        return authorDao.selectAuthorById(id);
    }

    public int deleteAuthorById(UUID id) {
        return authorDao.deleteAuthorById(id);
    }

    public int updateAuthor(UUID id, Author author) {
        return authorDao.updateAuthorById(id, author);
    }
}
