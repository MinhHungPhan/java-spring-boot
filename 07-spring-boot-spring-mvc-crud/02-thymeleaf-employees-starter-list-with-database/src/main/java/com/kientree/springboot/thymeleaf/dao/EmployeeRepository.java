package com.kientree.springboot.thymeleaf.dao;

import com.kientree.springboot.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Add a method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();

}
