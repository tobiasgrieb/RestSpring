package com.example.restservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingControllerTest {

    @Test
    void greeting() {
        GreetingController controller = new GreetingController();
        String response = controller.greeting();
        assertEquals("Hello World", response);
    }

}