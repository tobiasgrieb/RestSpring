package com.example.restservice.business;

import com.example.restservice.persistence.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("postgres") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int addBook(BookModel book) {
        return bookDao.insertBook(book);
    }

    public List<BookModel> getAllBooks() {
        return bookDao.selectAllBooks();
    }

    public Optional<BookModel> getBookById(UUID id) {
        return bookDao.selectBookById(id);
    }

    public int deleteBookById(UUID id) {
        return bookDao.deleteBookById(id);
    }

}
