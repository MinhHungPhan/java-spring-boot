# Spring Dependency Injection

This guide explores the concept of dependency injection in Spring, which makes use of the Dependency Inversion Principle. Dependency injection allows the client to delegate the responsibility of providing its dependencies to another object. In the context of a car factory example, the factory assembles various car parts to provide a fully functional car, demonstrating the idea of dependency injection.

## Table of Contents

- [Introduction to Dependency Injection](#introduction-to-dependency-injection)
- [The Role of the Spring Container](#the-role-of-the-spring-container)
- [Development Process with Constructor Injection](#development-process-with-constructor-injection)
- [Spring Auto Wiring](#spring-auto-wiring)
- [Conclusion](#conclusion)

## Introduction to Dependency Injection

Dependency Injection (DI) is a technique that involves injecting dependencies or helper components into an object. Instead of manually creating and managing these dependencies, DI delegates the responsibility to an external entity. In the Spring framework, the Spring container acts as the object factory and handles the injection of dependencies.

## The Role of the Spring Container

The Spring container functions as an object factory, and it facilitates the dependency injection process. In your application, you can communicate with the Spring container and request a specific object or dependency. The container then assembles and provides the required object along with its dependencies. The Spring container acts as the intermediary, enabling the seamless injection of dependencies into your application.

## Development Process with Constructor Injection

The development process typically involves the use of constructor injection. Follow these steps to utilize constructor injection in your Spring application:

1. Define the dependency interface and class: Create an interface, such as `Coach`, with the required methods, and implement it in a class, such as `CricketCoach`. Annotate the class with `@Component` to mark it as a Spring Bean.

2. Create a Demo REST Controller: Use the `@RestController` annotation to create a basic REST controller class, such as `CoachController`.

3. Create a constructor for injections: Define a private field, such as `myCoach`, and create a constructor for the `CoachController` class. Annotate the constructor with `@Autowired` to indicate that the dependency should be injected automatically.

4. Add a `@GetMapping` for the `/dailyworkout` endpoint: Use the `@GetMapping` annotation to map the `/dailyworkout` endpoint to a method in the `CoachController` class. Return the daily workout from the injected `myCoach` dependency.

## Spring Auto Wiring

Spring provides the option of auto wiring, where it automatically injects dependencies based on their type. With auto wiring, Spring scans for classes annotated with `@Component` and injects them when the corresponding dependency is required. For example, when injecting a `Coach` implementation, Spring searches for a class that implements the `Coach` interface and injects it accordingly.

## Conclusion

Dependency injection is a powerful technique in Spring that allows for the seamless management of dependencies in your application. By utilizing the Spring container and leveraging techniques such as constructor injection, you can achieve loosely coupled and highly maintainable code. Embrace the concept of dependency injection to enhance the modularity and flexibility of your Spring applications.
