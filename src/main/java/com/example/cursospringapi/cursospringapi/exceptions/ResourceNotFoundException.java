package com.example.cursospringapi.cursospringapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
