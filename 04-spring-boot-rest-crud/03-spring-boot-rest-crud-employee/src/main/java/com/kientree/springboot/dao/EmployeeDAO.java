package com.kientree.springboot.dao;

import com.kientree.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
