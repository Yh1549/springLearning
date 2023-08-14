package com.example.udemyapringboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" return "hello world!!"
    @GetMapping("/")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Running Hard!!!!";
    }
}
