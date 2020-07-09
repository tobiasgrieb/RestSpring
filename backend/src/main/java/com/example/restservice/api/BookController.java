package com.example.restservice.api;

import com.example.restservice.model.Book;
import com.example.restservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@Valid @NonNull @RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping(path = "{id}")
    public Book getBookById(@PathVariable("id") UUID id) {
        return bookService.getBookById(id)
            .orElse(null); // Message if not found
    }

    @DeleteMapping(path = "{id}")
    public void deleteBookById(@PathVariable("id") UUID id) {
        bookService.deleteBookById(id);
    }

    @PutMapping(path = "{id}")
    public void updateBookById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Book book) {
        bookService.updateBook(id, book);
    }
}
