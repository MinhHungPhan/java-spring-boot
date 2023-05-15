package com.kientree.springboot.thymeleaf.controller;

import com.kientree.springboot.thymeleaf.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // Load employee data

    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {

        // create employees
        Employee emp1 = new Employee("Harry", "Potter", "harry.potter@kientree.com");
        Employee emp2 = new Employee("Hermione", "Granger", "hermione.granger@kientree.com");
        Employee emp3 = new Employee("Ron", "Weasley", "ron.weasley@kientree.com");

        // create the list
        theEmployees = new ArrayList<>();

        // add to the list
        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    // Add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}
