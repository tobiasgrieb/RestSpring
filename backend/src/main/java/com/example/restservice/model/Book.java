package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Book {

    private UUID id;

    @NotBlank
    private String title;
    @NotBlank
    private String author;

    public Book(@JsonProperty("id") UUID id,
                @JsonProperty("title") String title,
                @JsonProperty("author") String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
