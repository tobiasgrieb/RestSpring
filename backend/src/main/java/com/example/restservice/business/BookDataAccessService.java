package com.example.restservice.business;

import com.example.restservice.persistence.BookModel;
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
    public int insertBook(BookModel book) {
        String sql = "INSERT INTO book (id, title, author) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
            sql,
            book.setId(),
            book.getTitle(),
            book.getAuthor()
        );
    }

    @Override
    public List<BookModel> selectAllBooks() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(
            sql,
            (resultSet, i) -> {
                UUID id =  UUID.fromString(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                return new BookModel(id, title, author);
            });
    }

    @Override
    public Optional<BookModel> selectBookById(UUID id) {
        String sql = "SELECT * FROM book WHERE id = ?";

        BookModel book = jdbcTemplate.queryForObject(
            sql,
            new Object[]{id},
            (resultSet, i) -> {
                UUID bookId = UUID.fromString(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                return new BookModel(bookId, title, author);
            });
        return Optional.ofNullable(book);
    }

    @Override
    public int deleteBookById(UUID book_id) {
        String sql = "DELETE FROM book WHERE id = ?";
        return jdbcTemplate.update(sql, book_id);
    }

}
