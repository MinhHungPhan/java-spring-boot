# Spring Boot Custom Application Properties

This guide explains how to configure custom application properties in a Spring Boot application. By utilizing an `application.properties` file, you can define custom properties and access them within your Spring Boot app. This approach eliminates the need for hardcoding values and provides a flexible configuration solution.

## Table of Contents

- [Introduction](#introduction)
- [Development Process](#development-process)
    - [Define Custom Properties](#define-custom-properties)
    - [Inject Properties into Spring Boot Application](#inject-properties-into-spring-boot-application)
    - [Access the Custom Properties](#access-the-custom-properties)
- [Conclusion](#conclusion)

## Introduction

When developing Spring Boot applications, it is often necessary to make the app configurable and avoid hardcoding values. One common requirement is to read application configuration from a properties file. Spring Boot provides a convenient mechanism to achieve this by utilizing the `application.properties` file.

By default, Spring Boot automatically loads information from the `application.properties` file located at `src/main/resources`. You can define custom properties in this file, and your Spring Boot app can access these properties using the `@Value` annotation. This eliminates the need for additional coding or configuration, as Spring Boot takes care of loading the `application.properties` file and making its contents available for use.

In the following sections, we will walk through the development process of defining custom application properties and injecting them into a Spring Boot application using the `@Value` annotation.

## Development Process

Follow these steps to define and inject custom application properties:

### Define Custom Properties

1. Create an `application.properties` file in the `src/main/resources` directory of your project.

2. Define your custom properties in the `application.properties` file. For example:
   ```properties
   coach.name=Harry Potter
   team.name=The Wizard Club

Feel free to add any number of custom properties based on your application's requirements.

### Inject Properties into Spring Boot Application

In your Spring Boot application, use the `@Value` annotation to inject the custom properties. Define fields in your code and annotate them with `@Value`, providing the corresponding property names. For example:

```java
@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // Rest of the code
}
```

### Access the Custom Properties

You can now access the custom properties within your Spring Boot application. In the above example, the `coachName` and `teamName` variables can be used in your code.

With this approach, Spring Boot automatically loads the `application.properties` file and makes the defined properties available for injection. There is no need for additional coding or configuration.

## Conclusion

Configuring custom application properties in Spring Boot allows for dynamic configuration of your application without hardcoding values. By defining properties in the `application.properties` file and injecting them using the `@Value` annotation, you can make your application more flexible and easily adaptable to different environments. Embrace the power of custom application properties in Spring Boot to enhance the configuration capabilities of your applications.
