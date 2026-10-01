package com.example.cursospringapi.cursospringapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor  
public class Message {

    private int id;
    String content;
}