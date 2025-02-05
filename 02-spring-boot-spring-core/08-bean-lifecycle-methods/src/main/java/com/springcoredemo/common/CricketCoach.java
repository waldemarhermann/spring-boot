package com.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void doSomeStuff() {
        System.out.println("In doSomeStuff(): " + getClass().getSimpleName());
    }

    // define destroy method
    @PreDestroy
    public void doSomeOtherStuff() {
        System.out.println("In doSomeOtherStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice every day Cricket!";
    }
}
