package com.example.restservice.api;

import com.example.restservice.persistence.GreetingModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public String greeting() {
        return "Hello and welcome to the bookstore application!";
    }

    @GetMapping("api/hello")
    public GreetingModel greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingModel(counter.incrementAndGet(), String.format(template, name));
    }
}
