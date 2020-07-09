package com.example.restservice;

import com.example.restservice.api.GreetingController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingControllerTest {

    @Test
    void greeting() {
        GreetingController controller = new GreetingController();
        String response = controller.greeting();
        assertEquals("Hello and welcome to the bookstore application!", response);
    }

}