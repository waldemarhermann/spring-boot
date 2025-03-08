package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.entity.Employee;
import com.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller // Gibt eine HTML-Seite (View-Name), wird für Web-Apps mit HTML-Views verwendet
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String showList(Model model) {

        // get list of employees from db
        List<Employee> listEmployees = employeeService.findAll();

        // add list to model
        model.addAttribute("employees", listEmployees);

        return "list-employees";
    }

    @GetMapping("/employees/showFormForAdd")
    public String showFormForAdd(Model model) {


        model.addAttribute("employee", new Employee());

        return "employees/employee-form";
    }
}
