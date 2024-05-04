# Saving a Java Object with JPA - Coding Part 2

## Table of Contents

- [Introduction](#introduction)
- [Project Overview](#project-overview)
- [Saving the Student Object](#saving-the-student-object)
- [Verifying Data Persistence](#verifying-data-persistence)
- [Running the Application](#running-the-application)
- [Best Practices](#best-practices)
- [Key Takeaways](#key-takeaways)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

Welcome to Part 2 of our tutorial on saving Java objects using the Java Persistence API (JPA) in a Spring Boot application. This document guides you through the process of integrating JPA to manage and persist data in a relational database.

## Project Overview

In this part of the tutorial, we continue from where we left off in [Part 1](../08-saving-a-java-object-with-jpa-coding-part-1/README.md). We'll update our main application to create and save a student object to our database. We'll also verify that the data is properly persisted.

## Saving the Student Object

In the `CrudApplication.java`, we modify the `CommandLineRunner` bean to include our `createStudent` method, which instantiates a new `Student` object and saves it using the `StudentDAO`.

```java
@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return  runner -> {
            createStudent(studentDAO);
		};
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
```

## Running the Application

Execute your Spring Boot application. After running, check the console and your MySQL Workbench to confirm the output.

## Verifying Data Persistence

### Step 1: Open MySQL Workbench

Launch MySQL Workbench and connect to your database server where your application’s data is stored.

### Step 2: Connect to the Database

Select the appropriate database connection (e.g., your local or development server) and connect to it. You should have your database credentials ready (username and password).

### Step 3: Select Your Database

Once connected, on the left-hand side panel under "SCHEMAS", find and click on the database you are using (`student_tracker` in this case). This will expand the list of tables, views, and stored procedures.

### Step 4: Open a New Query Tab

Click on the "File" menu at the top, and select "New Query Tab" to open a new workspace for writing and executing SQL queries.

### Step 5: Write and Run the SQL Query

In the new query tab, type the SQL command to retrieve the data you want to verify. If you want to check if student data has been correctly saved, you can use the following SQL command:

```sql
SELECT * FROM student_tracker.student;
```

Type this query in the query editor.

### Step 6: Execute the Query

Click the execute button (a lightning bolt icon) on the toolbar above the query editor to run your SQL command. This will execute the SQL query against the selected database.

### Step 7: Review the Results

After executing the query, the results will be displayed in the result grid at the bottom of the query tab. Verify the data to ensure that:
- The correct data has been inserted.
- The fields contain the expected values.
- No unexpected duplicates exist (unless intended).

## Best Practices

- **Code Organization**: Keep your persistence logic separate from your business logic.
- **Exception Handling**: Implement robust exception handling especially when dealing with database operations.
- **Use of DTOs**: Use Data Transfer Objects (DTOs) to pass data between processes.

## Key Takeaways

- JPA simplifies Java database operations.
- Organizing code into manageable segments improves maintainability.
- Verifying database changes is crucial after modifications.

## Conclusion

This guide has walked you through setting up, coding, and running a simple JPA application to manage student data. With these fundamentals, you can now expand your knowledge and tackle more complex data management tasks in Java applications.

## References

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Java Persistence API Specification](https://jakarta.ee/specifications/persistence/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Baeldung Tutorial on DTOs](https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application)