package com.example.udemyapringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;
    //define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("hi");
        myCoach = theCoach;
    }
    // setter injection(use for optional dependency)
//    @Autowired
//    public void doSome(Coach theCoach){
//        myCoach = theCoach;
//    }
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
