package com.elkabani.firstspringboot.controllers;

import com.elkabani.firstspringboot.entities.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/message")
    public Message getMessage() {
        return new Message("Hello from Spring Boot!");
    }
}
