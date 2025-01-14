package com.springboot.project.firstApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

    // expose "/" that return "Hi, ich bins"

    @GetMapping("/")
    public String sayHi() {
        return "Hi, ich bin Wowa";
    }
}
