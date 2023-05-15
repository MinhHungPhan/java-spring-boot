package com.kientree.springboot.thymeleaf.dao;

import com.kientree.springboot.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
