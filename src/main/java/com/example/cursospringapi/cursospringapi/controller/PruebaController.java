package com.example.cursospringapi.cursospringapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
REST Controller: Is a Java class that exposes HTTPS routes (URL endpoints) to the outside world. 
It is a Spring component that handles HTTP requests and responses. Is able to send and receive answers in JSON format.

    - is a REST Controller
    - Combines @Controller and @ResponseBody (ResponseBody is a JSON response)
*/

@RestController // Its a Web controller in API REST.
@RequestMapping("/micontroller") //We configurate an URL for all the controller methods.
public class PruebaController {
    
@GetMapping("/saludo") //We configurate an URL for this method.
   public String salute(){
    return "Hello World from Spring Boot";
   }
}