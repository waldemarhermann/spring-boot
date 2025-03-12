package com.springboot.demosecurity.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    @PostMapping("/logout")
    public String logout() {

        return "plain-login";
    }

}
