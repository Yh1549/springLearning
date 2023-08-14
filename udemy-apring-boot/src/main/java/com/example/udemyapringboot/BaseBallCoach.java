package com.example.udemyapringboot;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "baseball";
    }

    public BaseBallCoach() {
        System.out.println(getClass().getSimpleName());

    }
}
