package com.kientree.springboot.rest;

import com.kientree.springboot.entity.Employee;
import com.kientree.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // Quick and dirty: inject employee dao (use constructor injection)

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // Add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw  new RuntimeException("Employeed id is not found - " + employeeId);
        }

        return  employee;
    }

    // Add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        // Also just in case they pass an id in JSON ... set id to 0
        // This is to force a save  of new item ... instead of update
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    // Add mapping for PUT /employees - update an existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    // Add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        // Throw exception if null

        if(employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
