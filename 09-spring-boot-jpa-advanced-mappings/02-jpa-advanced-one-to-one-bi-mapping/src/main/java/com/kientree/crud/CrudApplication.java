package com.kientree.crud;

import com.kientree.crud.dao.AppDAO;
import com.kientree.crud.entity.Instructor;
import com.kientree.crud.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Deleting instructor id: " + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: " + instructor);
		System.out.println("the associated instructorDetail only:" + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		// Create the instructor
		Instructor instructor = new Instructor("John", "Doe", "john.doe@kientree.com");

		// Create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/johndoe", "Guitar");

		// Associate the instructor detail with the instructor
		instructor.setInstructorDetail(instructorDetail);

		// Save the instructor using the AppDAO

		// Note: this will also save the InstructorDetail object because of CascadeType.all

		System.out.println("Saving instructor: " + instructor);

		appDAO.save(instructor);

		System.out.println("Done!");
	}
}
