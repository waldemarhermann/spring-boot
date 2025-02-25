package com.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    // controller method to show initial HTML form
    @GetMapping ("/showForm")
    public String showForm() {
        return "helloworld-form";
    }


    // controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }


    @RequestMapping("/processFormVersionTwo")
    public String nameUppercase(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName");

        String nameUp = name.toUpperCase();

        model.addAttribute("message", nameUp);

        return "helloworld";
    }

    @GetMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name,
                                          Model model) {

        String nameUp = name.toUpperCase();

        model.addAttribute("message", nameUp);

        return "helloworld";
    }



}
