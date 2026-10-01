package com.example.cursospringapi.cursospringapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursospringapi.cursospringapi.model.Message;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    
    private final List<Message> messages = new ArrayList<>();

    public MessageController(){
        messages.add(new Message(1, "Hello World from Spring Boot"));
        messages.add(new Message(2, "Hello World from Spring Boot 2"));
    }

    @GetMapping
    public List<Message> getMessages() {
        return messages;
    }

    /*
        @PathVariable is an annotation that indicates that a method parameter should be bound to a URI template variable. In this case, it binds the id parameter to the {id} path variable in the URL.
        .stream is a method that converts a collection into a stream of data.
        m is a lambda expression that represents a message object in the stream. It is used to access the properties of the message object.
        .filter is a method that filters the elements of a stream based on a given condition. In this case, it filters the messages based on their id.
        .findFirst is a method that returns the first element of a stream that matches the given condition. In this case, it returns the first message that has the specified id.
        Optional is a container object which may or may not contain a non-null value. It is used to avoid null checks and NullPointerExceptions. In this case, it is used to handle the case where a message with the specified id is not found.
    */
    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable int id) {
        Optional<Message> message = messages.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
                return message.orElse(null); // If the message is not found, return null.
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        messages.add(message);
        return message;

    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message message){
        Optional<Message> existingMessage = messages.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
        if (existingMessage.isPresent()) {
            messages.remove(existingMessage.get());
            message.setId(id); // Ensure the ID remains the same for the updated message
            messages.add(message);
            return message;
        } else {
            return null; // If the message is not found, return null.
        }
    }

    @DeleteMapping ("/{id}")
    public void deleteMessage(@PathVariable int id){
        Optional<Message> existingMessage = messages.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
        existingMessage.ifPresent(messages::remove);
    }
}