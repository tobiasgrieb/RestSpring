package com.example.restservice.dao;

import com.example.restservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BookDataAccessService implements BookDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertBook(Book book) {
        return 0;
    }

    @Override
    public List<Book> selectAllBooks() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(
            sql,
            (resultSet, i) -> {
                UUID id =  UUID.fromString(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                return new Book(id, title, author);
            });
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        String sql = "SELECT * FROM book WHERE id = ?";

        Book book = jdbcTemplate.queryForObject(
            sql,
            new Object[]{id},
            (resultSet, i) -> {
                UUID bookId = UUID.fromString(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                return new Book(bookId, title, author);
            });
        return Optional.ofNullable(book);
    }

    @Override
    public int deleteBookById(UUID id) {
        return 0;
    }

    @Override
    public int updateBookById(UUID id, Book book) {
        return 0;
    }

}
