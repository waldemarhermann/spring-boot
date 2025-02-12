package com.demo.rest;

import com.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Waldemar", "Hermann"));
        theStudents.add(new Student("Andrej", "Bartenbaum"));
        theStudents.add(new Student("Eugen", "Lichtner"));
        theStudents.add(new Student("Galina", "Leyman"));
    }

    // define endpoint for "/students" - return a  list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint for "/student" - return only one student
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        return theStudents.get(studentId);
    }

}
