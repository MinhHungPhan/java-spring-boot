# Spring Boot Project Setup - part 2

This guide provides a comprehensive guide for beginners on setting up and configuring a Spring Boot application. It includes step-by-step instructions on configuring the `application.properties` file for database connectivity, managing application logging, and customizing application behavior.

## Table of Contents

- [Introduction](#introduction)
- [Configuring the Application.properties File](#configuring-the-applicationproperties-file)
- [Running and Testing the Application](#running-and-testing-the-application)
- [Handling Application Errors](#handling-application-errors)
- [Customizing Spring Boot Behavior](#customizing-spring-boot-behavior)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

Spring Boot is a powerful framework for building Java applications with minimal setup. It automates many processes, making it easier for developers to start and scale their applications. This guide focuses on setting up database connections and configuring the application's behavior and logging levels.

## Configuring the Application.properties File

The `application.properties` file in a Spring Boot project is crucial for configuring application-level settings. For database connectivity, you need to specify the JDBC URL, username, and password. Here's an example for a MySQL database:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker
spring.datasource.username=springstudent
spring.datasource.password=springstudent
```

Replace these values with your actual database information.

## Running and Testing the Application

Once you've configured the database settings, run your application. If the setup is correct, the application should connect to the database successfully. Look for logs indicating a successful connection. For instance, logs mentioning "added a connection" imply a successful database connection.

## Handling Application Errors

To test error handling, intentionally use incorrect database credentials. Upon running the application, it should throw exceptions indicating a failed database connection. This step is crucial for understanding how Spring Boot handles connection errors.

## Customizing Spring Boot Behavior

To tailor your Spring Boot application to your needs, you can modify its behavior through `application.properties`. For instance:

1. **Disabling the Spring Boot Banner**: If you prefer not to see the Spring Boot startup banner, add the following line:

```properties
spring.main.banner-mode=off
```

2. **Adjusting Logging Levels**: To reduce logging verbosity, set the logging level to `warn`:

```properties
logging.level.root=warn
```

This setting ensures that only warnings and errors are logged, reducing the amount of log output during application execution.

## Conclusion

Setting up and customizing a Spring Boot application is a straightforward process. By properly configuring your `application.properties` file and understanding how to manage logging and application behavior, you can effectively tailor the application to meet your needs.

## References

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [Understanding the Spring Boot Banner](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-banner)

By utilizing these steps and references, you are well on your way to mastering the basics of Spring Boot application setup and configuration.