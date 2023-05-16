package com.kientree.springboot.thymeleaf.controller;

import com.kientree.springboot.thymeleaf.entity.Employee;
import com.kientree.springboot.thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // Load employee data

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get the employees from the database
        List<Employee> theEmployees = employeeService.findAll();
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }
}
