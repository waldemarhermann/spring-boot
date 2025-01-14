package com.springboot.project.firstApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

    // inject properties

    @Value("${developer.name}")
    private String name;

    @Value("${developer.surname}")
    private String surname;

    // expose "/" that return "Hi, ich bins"

    @GetMapping("/")
    public String sayHi() {
        return "Hi, ich bins";
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "lets do Workout";
    }

    @GetMapping("/fortune")
    public String getFortune() {
        return "this will be your lucky year";
    }

    @GetMapping("/fullname")
    public String getName() {
        return "Name: " + name + ", Vorname: " + surname;
    }


}
