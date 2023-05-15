package com.kientree.springboot.thymeleaf.service;

import com.kientree.springboot.thymeleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}