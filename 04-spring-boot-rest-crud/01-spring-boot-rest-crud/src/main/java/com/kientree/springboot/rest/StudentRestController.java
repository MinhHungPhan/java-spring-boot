package com.kientree.springboot.rest;

import com.kientree.springboot.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

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

        // check the studentId against list size
        if((studentId >= students.size() || (studentId < 0))){
            throw  new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){

        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add another exception handler to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){

        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
