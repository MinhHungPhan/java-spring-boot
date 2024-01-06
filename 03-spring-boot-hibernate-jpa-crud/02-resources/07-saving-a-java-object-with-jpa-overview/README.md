# Saving a Java Object with JPA Overview

## Table of Contents

- [Introduction](#introduction)
- [Usage and Examples](#usage-and-examples)
- [Student Data Access Object](#student-data-access-object)
- [JPA Entity Manager](#jpa-entity-manager)
- [Spring @Transactional](#spring-transactional)
- [Specialized Annotation for DAOs](#specialized-annotation-for-daos)
- [Student DAO](#student-dao)
- [Best Practices](#best-practices)
- [Key Takeaways](#key-takeaways)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

Welcome to the guide on saving a Java object using the Java Persistence API (JPA). This document is designed for individuals who are new to JPA and wish to understand how it can be used to persist Java objects into databases. We'll cover everything from the basic setup to more advanced concepts, with simple examples and explanations tailored for beginners.

## Usage and Examples

### Sample App Features

- Create a new Student
- Read a Student
- Update a Student
- Delete a Student

### Creating a New Student:

```java
// Code to create a new student
Student student = new Student("John", "Doe", "john.doe@email.com");
studentDAO.save(student);
```

### Reading a Student:

```java
// Code to read a student
Student student = studentDAO.findById(studentId);
```

## Student Data Access Object

The Data Access Object (DAO) is a pattern used to separate the application layer from the persistence layer. The StudentDAO will be responsible for managing the database operations related to `Student` entities. Here are the key methods defined in the `StudentDAO`:

### `save(Student student)`

- **Purpose**: Persists a new student entity or updates an existing one in the database.
- **Usage Example**:

```java
Student student = new Student("John", "Doe", "john.doe@email.com");
studentDAO.save(student);
```

### `findById(Long id)`

- **Purpose**: Retrieves a student by their unique ID.
- **Usage Example**:

```java
Student student = studentDAO.findById(1);
```

### `findAll()`

- **Purpose**: Fetches all student entities from the database.
- **Usage Example**:

```java
List<Student> students = studentDAO.findAll();
```

### `findByLastName(String lastName)`

- **Purpose**: Finds all students with a given last name.
- **Usage Example**:

```java
List<Student> doeStudents = studentDAO.findByLastName("Doe");
```

### `update(Student student)`

- **Purpose**: Updates an existing student's details in the database.
- **Usage Example**:

```java
student.setFirstName("Jane");
studentDAO.update(student);
```

### `delete(Student student)`

- **Purpose**: Removes a student entity from the database.
- **Usage Example**:

```java
studentDAO.delete(existingStudent);
```

### `deleteAll()`

- **Purpose**: Deletes all students from the database.
- **Usage Example**:

```java
studentDAO.deleteAll();
```

These methods collectively provide a comprehensive interface for managing `Student` entities in a database using JPA. They offer basic CRUD (Create, Read, Update, Delete) functionality, which is essential for most data-driven applications.

## JPA Entity Manager

The JPA Entity Manager is the primary JPA interface used to interact with the database. It manages the lifecycle of entities and provides operations such as persisting, merging, removing, and finding entities.

### Key points

- **Primary JPA Interface**: The JPA Entity Manager is the main component for interacting with the database in the context of JPA.

- **Managing Entity Lifecycle**: It handles various operations such as persisting, merging, removing, and finding entities in the database.

- **Usage in DAO**: In the context of the Student Data Access Object (DAO), the Entity Manager is used for executing database operations related to the `Student` entities.

- **Necessity for Data Source**: The JPA Entity Manager requires a data source, which defines the database connection information.

- **Automatic Creation in Spring Boot**: When using Spring Boot, the JPA Entity Manager and the data source are automatically created based on the configuration in the `pom.xml` file and `application.properties`.

- **Dependency Injection**: The Entity Manager can be injected into DAOs, like the Student DAO, using Spring's `@Autowired` annotation.

- **Transactional Management**: The Entity Manager operates within transactions, which can be managed using the `@Transactional` annotation in Spring, automating the transaction boundaries.

- **Interaction with Database**: It communicates with the actual database, performing operations defined in the DAO.

These points encapsulate the role and functionality of the JPA Entity Manager in the context of managing database operations, particularly with regard to Java objects and entities.

### Diagram

```plaintext
┌────────────────┐           ┌────────────────┐           ┌────────────────┐          ┌────────────────┐
│                │           │                │           │                │          │                │
│                │           │                │           │                │          │                │
│  Student DAO   │◀────────▶ │ Entity Manager │◀────────▶ │  Data Source   │◀────────▶│     Storage    │
│                │           │                │           │                │          │                │
│                │           │                │           │                │          │                │
└────────────────┘           └────────────────┘           └────────────────┘          └────────────────┘
```

## Spring @Transactional

The `@Transactional` annotation in Spring is a key concept for handling database transactions when using JPA. This section aims to simplify its understanding and highlight its importance.

- **What is `@Transactional`?**
  - It is an annotation provided by the Spring framework used to declare transaction boundaries.
  - When you annotate a method with `@Transactional`, Spring automatically starts a transaction before the method executes and commits it after the method completes.

- **Why Use `@Transactional`?**
  - **Automated Transaction Management**: It automates the process of beginning and ending transactions, reducing the need for manual transaction management in your code.
  - **Error Handling**: If an error occurs within a method marked as `@Transactional`, the transaction will be automatically rolled back, preventing any partial changes from affecting the database.
  
- **Why is This Important?**:
  - **Prevents Partial Updates**: Without this rollback, you might end up with partial changes. For instance, if your transaction was supposed to update 10 records, and an error occurred after 6 were updated, you'd have inconsistency in your data.
  - **Maintains Data Integrity**: By rolling back the entire transaction when an error occurs, Spring ensures that your data remains consistent and reliable. Either all changes are applied, or none are, so there's no in-between state that could lead to data integrity issues.

- **Where to Apply `@Transactional`?**
  - **DAO Methods**: Commonly used in DAO (Data Access Object) implementations, particularly for methods that modify the database (like `save`, `update`, and `delete`).
  - **Service Layer Methods**: Can also be applied to service layer methods that encapsulate business logic involving multiple database operations.

- **How Does It Work?**

When you use the `@Transactional` annotation in a Spring application, it works in a sophisticated way under the hood. Here's a step-by-step explanation:

1. **Creation of a Proxy**:
   - **What is a Proxy?**: In programming, a proxy is like a wrapper or an intermediary that adds additional behavior to an object or method. In this case, Spring creates a proxy around the method that is annotated with `@Transactional`.
   - **Purpose of the Proxy**: This proxy is responsible for managing the transactional behavior of the method. It adds the transaction management capabilities to the method without altering the method's actual code.

2. **Handling Transactions When the Method is Called**:
   - **Starting or Joining a Transaction**: When a method annotated with `@Transactional` is called, the proxy checks if there is an ongoing database transaction. If there is no existing transaction, it starts a new one. If a transaction is already in progress, it joins that transaction.
   - This means that the operations performed in the method become part of a single database transaction.

3. **Committing or Rolling Back the Transaction**:
   - **Upon Successful Completion**: If the method completes its execution without any errors, the proxy instructs the database to commit the transaction. This means all the changes made during the transaction are saved permanently in the database.
   - **In Case of an Exception**: If an error or exception occurs during the execution of the method, the proxy instructs the database to roll back the entire transaction. This means any changes that were made since the start of the transaction are undone, as if they never happened.

- **Benefits of Using `@Transactional`**
  - **Simplified Code**: Reduces boilerplate code for transaction management.
  - **Consistent Behavior**: Ensures consistent transactional behavior across your application.
  - **Improved Error Handling**: Makes the error handling process more robust by handling transaction rollbacks automatically.

## Specialized Annotation for DAOs

Spring provides specialized annotations for DAOs, such as `@Repository`. The `@Repository` annotation in Spring Framework is a simple way to tell Spring that a particular class is used for accessing data. Think of it like a label you put on a class to let Spring know that this class should be treated as part of the database access code, also known as a Data Access Object (DAO).

### Key Points

- **`@Repository` Annotation**:
  - **Sub-Annotation of `@Component`**: `@Repository` is a specialized annotation in Spring, considered a specific form of the more general `@Component` annotation.
  - **Purpose**: It is used to indicate that a class provides the mechanism for storage, retrieval, update, and search operations on objects.

- **Benefits of Using `@Repository`**:
  - **Automatic DAO Implementation Registration**: By annotating DAO implementations with `@Repository`, Spring automatically registers them thanks to its component scanning mechanism.
  - **Exception Translation**: Spring provides translation of JDBC-related exceptions. This means it converts checked JDBC exceptions into unchecked DataAccessExceptions, simplifying error handling in the persistence layer.

### Example 

- **Example of DAO Implementation with `@Repository`**:

```java
@Repository
public class StudentDAOImpl implements StudentDAO {
    // Implementation details...
}
```

In this example, the `StudentDAOImpl` class is annotated with `@Repository`, making it a part of Spring's component scanning and exception translation mechanism.

- **Enhanced Code Management**:
  - Using `@Repository` for DAOs leads to cleaner and more maintainable code, as it clearly separates the DAO layer from the business logic layer.
  - It also ensures that DAOs are properly managed and integrated within the Spring context, benefiting from Spring's rich features like dependency injection and declarative transaction management.

## Student DAO

### Step 1: Define DAO interface

```java
public interface StudentDAO {
    void save(Student student);
    // Other methods...
}
```

### Step 2: Define DAO implementation

```java
@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    // Other methods...
}
```

### Step 3: Update main app

Update the main application to use the StudentDAO for CRUD operations on `Student` entities.

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

## Best Practices

- Use clear and consistent naming conventions.
- Keep the DAO layer separate from the service layer.
- Ensure proper exception handling, particularly for database operations.
- Utilize the `@Transactional` annotation to manage transactions.

## Key Takeaways

- Understanding the basics of JPA and the Entity Manager.
- Knowing how to create a DAO for managing entity persistence.
- The importance of using specialized annotations like `@Repository` and `@Transactional` for clearer and safer database interactions.

## Conclusion

This document has provided an overview of how to save Java objects using JPA. By following the outlined steps and best practices, you can effectively manage your database operations and ensure your applications are robust and maintainable. Feel free to contribute to this document or provide feedback to improve it. Happy coding! 🚀

## References

- [Java Persistence API (JPA) Specification](https://url-to-specification)
- [Spring Data JPA Documentation](https://url-to-spring-data-jpa-doc)