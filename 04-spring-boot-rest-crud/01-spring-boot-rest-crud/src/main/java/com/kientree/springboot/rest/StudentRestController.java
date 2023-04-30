package com.kientree.springboot.rest;

import com.kientree.springboot.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // Define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("Alice", "Wonderful"));
        students.add(new Student("Lucy", "Wang"));

        return students;
    }
}
