package com.kientree.springboot.rest;

import com.kientree.springboot.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // Define @PostConstruct to load the student data...only once!
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("Alice", "Wonderful"));
        students.add(new Student("Lucy", "Wang"));
    }

    // Define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    // Define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list...keep ut simple for now

        return students.get(studentId);
    }

}
