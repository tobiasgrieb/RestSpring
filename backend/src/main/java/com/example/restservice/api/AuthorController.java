package com.example.restservice.api;

import com.example.restservice.model.Author;
import com.example.restservice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/author")
@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public void addAuthor(@Valid @NonNull @RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @GetMapping(path = "{id}")
    public Author getAuthorById(@PathVariable("id") UUID id) {
        return authorService.getAuthorById(id)
            .orElse(null); // Message if not found
    }

    @DeleteMapping(path = "{id}")
    public void deleteAuthorById(@PathVariable("id") UUID id) {
        authorService.deleteAuthorById(id);
    }

    @PutMapping(path = "{id}")
    public void updateAuthorById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Author author) {
        authorService.updateAuthor(id, author);
    }
}
