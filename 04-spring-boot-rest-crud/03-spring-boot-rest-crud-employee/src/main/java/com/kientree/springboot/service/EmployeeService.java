package com.kientree.springboot.service;

import com.kientree.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
