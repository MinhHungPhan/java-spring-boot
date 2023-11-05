# Spring Boot Project Setup - part 1

This guide provides instructions on how to create a Spring Boot project with the help of Spring Initializr. It's aimed at beginners who are getting started with Spring Boot and includes detailed instructions on how to create a project, add dependencies, and set up a command line application within Spring Boot.

## Table of Contents

- [Introduction](#introduction)
- [Creating the Project with Spring Initializr](#creating-the-project-with-spring-initializr)
- [Setting up Project Metadata](#setting-up-project-metadata)
- [Adding Dependencies](#adding-dependencies)
- [Downloading and Extracting the Project](#downloading-and-extracting-the-project)
- [Opening the Project in IntelliJ IDEA](#opening-the-project-in-intellij-idea)
- [Creating a Command Line Runner](#creating-a-command-line-runner)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

Spring Boot is an extension of the Spring framework that simplifies the initial setup and development of new Spring applications. It enables developers to start with minimal configurations without the need for an entire Spring configuration setup. This guide will walk you through the process of setting up a basic Spring Boot application for a Maven project using Java and demonstrate how to add specific dependencies such as the MySQL driver and Spring Data JPA.

## Creating the Project with Spring Initializr

Spring Initializr is a convenient web-based tool provided by the Spring team to create Spring Boot projects. To begin:

1. Open your web browser and navigate to [Spring Initializr](https://start.spring.io).
2. Under the "Project" section, select "Maven Project."

## Setting up Project Metadata

Project metadata includes details such as the group and artifact ID that uniquely identify your project within a Maven repository:

1. For **Group**, use `com.kientree`.
2. Set the **Artifact** ID to `crud`.

## Adding Dependencies

To add functionality to your project, you will need to include dependencies. For this example, we'll add MySQL and Spring Data JPA:

1. In the "Dependencies" section, search for and add `MySQL Driver`.
2. Search for and add `Spring Data JPA`.

Make sure you have selected these two dependencies as shown on the Spring Initializr's website.

## Downloading and Extracting the Project

After setting up your project and dependencies:

1. Click on the "Generate" button.
2. Download the `crud.zip` file to your local system.
3. Extract the file and copy the resulting folder to your desired development directory (e.g., `JAVA-SPRING-BOOT/03-spring-boot-hibernate-jpa-crud`).

## Opening the Project in IntelliJ IDEA

IntelliJ IDEA is a popular IDE for Java development. To open your project:

1. Start IntelliJ IDEA and select "Open."
2. Navigate to your project directory (e.g., `01-crud-student`) and open it.

Inside the directory, you'll find the Maven `POM.xml` file among other project files.

## Creating a Command Line Runner

A command line runner in Spring Boot is used to execute code after the application context is loaded. Here's how you can set it up:

1. Open the main Spring Boot application class (typically named `Application.java` or with `@SpringBootApplication` annotation).
2. Define a new bean of type `CommandLineRunner` using a Java lambda expression to simplify the implementation.

```java
@Bean
public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> System.out.println("Hello World!");
}
```

This code will print "Hello World!" to the console once the application runs and all Spring beans are loaded.

## Conclusion

Setting up a Spring Boot project with Spring Initializr and adding dependencies for MySQL and Spring Data JPA is a straightforward process. By following the steps outlined in this guide, you will have a basic project structure ready for future development. Remember to extend the functionality by adding your custom beans and creating your application logic as needed.

## References

- [Spring Initializr](https://start.spring.io)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

By utilizing these resources and the steps provided, you can efficiently start a new Spring Boot application and prepare it for your development tasks.