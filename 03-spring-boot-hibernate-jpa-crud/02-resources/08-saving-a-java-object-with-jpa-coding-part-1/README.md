# Saving a Java Object with JPA - Coding Part 1

Welcome to our guide on saving Java objects using the Java Persistence API (JPA)! This document is designed for beginners and aims to provide a clear and straightforward introduction to integrating JPA into your Java applications, focusing on creating and managing a Data Access Object (DAO) for persisting student information. Whether you are new to JPA or looking to refine your skills, this guide will walk you through the necessary steps with examples, best practices, and key takeaways.

## Table of Contents

- [Introduction](#introduction)
- [Creating the DAO Package](#creating-the-dao-package)
- [Defining the DAO Interface](#defining-the-dao-interface)
- [Implementing the DAO](#implementing-the-dao)
- [Best Practices](#best-practices)
- [Key Takeaways](#key-takeaways)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

Data persistence is a critical aspect of software development, enabling applications to store data across sessions. The Java Persistence API (JPA) is a popular standard for ORM (Object-Relational Mapping), allowing developers to manage relational data in Java applications using a more object-oriented approach. This guide focuses on creating a Data Access Object (DAO) to abstract and encapsulate all access to the data source, specifically for saving student objects to a database.

## Creating the DAO Package

To properly organize your code, start by creating a new package within your project:

1. **Open Your IDE:** Start by opening your Integrated Development Environment (IDE) where your project is located.

2. **Navigate to Your Project Structure:** In your IDE, find the project explorer or navigator panel. This panel displays the structure of your project, including its packages and classes.

3. **Locate the `com.kientree.crud` Package:** Within the project structure, navigate to the `com.kientree.crud` package. If this package does not exist, you'll need to create it by right-clicking on the `src` directory (or appropriate source directory for your project), choosing `New > Package`, and then entering `com.kientree.crud` as the package name.

4. **Create the `dao` Package:**
    - Right-click on the `com.kientree.crud` package.
    - Select `New > Package` from the context menu.
    - In the dialog that appears, enter `dao` as the name of the new package.
    - Click `OK` or `Finish` (depending on your IDE) to create the package.

5. **Verify the Package Creation:** After creating the package, you should see a new package named `dao` under `com.kientree.crud` in your project structure. This is where you'll create your DAO interface and implementation classes.

## Defining the DAO Interface

### Step 1: Create the DAO Interface

Our journey begins with defining a DAO interface, `StudentDAO`, to outline the operations that can be performed on the student entities. This interface serves as a contract, specifying methods such as `save`, `findById`, `findAll`, and others relevant to managing student data.

```java
package com.kientree.crud.dao;

import com.kientree.crud.entity.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
}
```

## Implementing the DAO

### Step 2: DAO Implementation

After defining the `StudentDAO` interface, the next step is to create an implementation, `StudentDAOImpl`, that realizes the interface's methods. This implementation interacts with the database using the `EntityManager`, provided by JPA, to perform CRUD (Create, Read, Update, Delete) operations on student entities.

```java
package com.kientree.crud.dao;

import com.kientree.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    // Additional method implementations...
}
```

## Best Practices

- **Use Clear Method Names:** Ensure your DAO methods have clear, descriptive names that reflect their purpose, like `save`, `findById`, or `deleteAll`.
- **Leverage Constructor Injection:** Prefer constructor injection for dependencies like `EntityManager` to promote immutability and ease of testing.
- **Transactional Annotations:** Apply `@Transactional` annotations appropriately to manage database transactions smoothly and effectively.

## Key Takeaways

- **JPA and DAOs:** Understanding how to use JPA within DAOs to manage data persistence is crucial for developing robust Java applications.
- **Separation of Concerns:** DAOs help in separating the persistence logic from the business logic, making your application more modular and maintainable.
- **Transactional Management:** Proper use of transactional management ensures data integrity and consistency across operations.

## Conclusion

This guide has introduced you to saving Java objects using JPA by defining and implementing a DAO. By following the steps, examples, and best practices provided, you're well on your way to effectively managing data persistence in your Java applications. Continue exploring and experimenting with JPA to deepen your understanding and enhance your skills.

## References

- [Official JPA Documentation](https://jakarta.ee/specifications/persistence/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)