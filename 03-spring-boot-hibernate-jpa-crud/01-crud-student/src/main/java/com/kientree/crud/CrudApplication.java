package com.kientree.crud;

import com.kientree.crud.dao.StudentDAO;
import com.kientree.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){


		return  runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
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
