package com.example.udemyapringboot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println(getClass().getSimpleName());
    }
    @PostConstruct
    public void doSome(){
        System.out.println("create business logic");
    }
    @PreDestroy
    public void dosomeDestory(){
        System.out.println("destroy business logic");
    }
    @Override
    public String getDailyWorkout() {
        return "practice Cricket";
    }
}
