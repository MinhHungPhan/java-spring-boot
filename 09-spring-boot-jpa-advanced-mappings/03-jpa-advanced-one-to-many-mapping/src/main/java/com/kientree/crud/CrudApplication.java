package com.kientree.crud;

import com.kientree.crud.dao.AppDAO;
import com.kientree.crud.entity.Course;
import com.kientree.crud.entity.Instructor;
import com.kientree.crud.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructorDetail(appDAO);

			// createInstructorWithCourses(appDAO);

			// findInstructorWithCourses(appDAO);

			// findCoursesForInstructor(appDAO);

			findInstructorWithCoursesJoinFetch(appDAO);
		};
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		// Find instructor by id
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("The associated courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		// Find instructor by id
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		// Find courses for instructor
		System.out.println("Finding courses for instructor id: " + id);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		// Associate the objects
		instructor.setCourses(courses);

		System.out.println("The associated courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("The associated courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// Create the instructor
		Instructor instructor = new Instructor("Harry", "Potter", "harry.potter@kientree.com");

		// Create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/harrypotter", "Quidditch");

		// Associate the instructor detail with the instructor
		instructor.setInstructorDetail(instructorDetail);

		// Create some courses

		Course course1 = new Course("History of Magic");
		Course course2 = new Course("Defence Against the Dark Arts");

		// Add courses to instructor

		instructor.add(course1);
		instructor.add(course2);

		// Save the instructor
		// NOTE: this will also save the courses because of CascadeType.PERSIST

		System.out.println("Saving instructor: " + instructor);
		System.out.println("Saving instructor: " + instructor.getCourses());
		appDAO.save(instructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int id = 3;
		System.out.println("Deleting instructor detail id: " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// Get the instructor detail object
		int id = 2;

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		// Print the instructor detail
		System.out.println("instructorDetail: " + instructorDetail);

		// Print the associated instructor
		System.out.println("the associated instructor: " + instructorDetail.getInstructor());

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
