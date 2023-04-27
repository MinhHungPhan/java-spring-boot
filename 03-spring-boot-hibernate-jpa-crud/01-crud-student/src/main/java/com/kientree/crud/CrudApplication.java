package com.kientree.crud;

import com.kientree.crud.dao.StudentDAO;
import com.kientree.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){


		return  runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			deleteStudentt(studentDAO);
		};
	}

	private void deleteStudentt(StudentDAO studentDAO) {

		int studentId =3;
		System.out.println("Getting student with id: " + studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		// Retrieve student based on the id: primary key
		int studentId = 1; // Replace 1 with the actual id of the student you want to update
		System.out.println("Getting student with id: " + studentId);
		Student theStudent = studentDAO.findById(studentId);

		System.out.println("Updating student");
		// Change first name to "John"
		theStudent.setFirstName("John");

		// Update the student
		studentDAO.update(theStudent);

		// Display the updated student
		System.out.println("Updated student: " + theStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// Get a list of students by last name
		List<Student> students = studentDAO.findByLastName("Doe");

		// Display the list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// Get a list of students
		List<Student> students = studentDAO.findAll();

		// Display the list of students
		for (Student student : students) {
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// Create a student object
		System.out.println("Creating new student object...");
		Student theStudent = new Student("Tom", "Jerry", "tom.jerry@example.com");

		// Save the student
		System.out.println("Saving the student...");
		studentDAO.save(theStudent);

		// Display id of the saved student
		System.out.println("Saved student with id: " + theStudent.getId());

		// Retrieve student based on the id: primary key
		Student retrievedStudent = studentDAO.findById(theStudent.getId());

		// Display student
		System.out.println("Retrieved student: " + retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple students
		System.out.println("Creating 3 student objects...");
		Student student1 = new Student("Emily", "David", "emily.david@kientree.com");
		Student student2 = new Student("Jane", "Smith", "jane.smith@kientree.com");
		Student student3 = new Student("Bob", "Johnson", "bob.johnson@kientree.com");

		// Save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("Creating new student object...");
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setEmail("johndoe@kientree.com");

		// Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// Display id of the saved student
		System.out.println("Saved student with id: " + student.getId());
	}

}
