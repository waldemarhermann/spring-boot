package com.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public String getDailyWorkout() {
        return "Practice every day Baseball!";
    }

}
