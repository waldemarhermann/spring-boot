package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        // create a student object
        Student student = new Student();

        // add student object to the modell
        model.addAttribute("student", student);

        // add list of countries
        model.addAttribute("countries", countries);

        // add list of languages
        model.addAttribute("languages", languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student tempStudent) {

        System.out.println("Student name: " + tempStudent.getFirstName() + " " + tempStudent.getLastName());

        return "student-confirmation";

    }

}
