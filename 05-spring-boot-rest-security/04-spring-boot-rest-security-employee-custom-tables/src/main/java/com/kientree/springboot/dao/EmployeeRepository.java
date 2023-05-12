package com.kientree.springboot.dao;

import com.kientree.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path="members")

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
