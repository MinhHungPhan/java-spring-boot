# Spring Boot Actuator - Security

Welcome to the Spring Boot Actuator - Security guide! This guide aims to provide you with an understanding of how to secure Spring Boot Actuator endpoints using Spring Security. 

## Table of Contents:
- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [Excluding Endpoints](#excluding-endpoints)
- [Additional Resources](#additional-resources)
- [Development Process](#development-process)
- [Conclusion](#conclusion)

## Introduction

Spring Boot Actuator is a powerful tool that exposes various management endpoints for monitoring and managing your Spring Boot application. However, it is essential to protect these endpoints from unauthorized access to maintain the security of your application's sensitive information.

In this guide, we will walk you through the process of securing the Actuator endpoints by adding Spring Security to your project. We will cover topics such as configuring authentication, customizing user credentials, and excluding specific endpoints from public access.

## Getting Started

To secure the Actuator endpoints, follow these steps:

1. Add the `spring-boot-starter-security` dependency to your Maven project.

2. By default, the `/health` endpoint will still be available. If you want to disable it, refer to the next section.

3. Accessing `/actuator/beans` will prompt Spring Security to request a login. Enter the default username and password.
   - Default username: `user`
   - Default password: The generated-security password shown in the console logs.

4. If you wish to override the default username and password, modify the `application.properties` file as follows:
```properties
spring.security.user.name=scott
spring.security.user.password=tiger
```
Replace `scott` with your desired username and `tiger` with your desired password.

5. For advanced customization of Spring Security, such as using a database for roles and encrypted passwords, further details will be covered in the course.

## Excluding Endpoints

To exclude specific endpoints, such as `/health` and `/info`, add the following entry to the `application.properties` file:
```properties
management.endpoints.web.exposure.exclude=health, info
```

With this configuration, only authorized users can access the excluded endpoints.

## Additional Resources

For more detailed information on Spring Boot Actuator, visit the official documentation: [www.luv2code.com/actuator-docs](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator)

## Development Process

To secure the Actuator endpoints and disable certain endpoints:

1. Edit the `pom.xml` file and add the `spring-boot-starter-security` dependency.
2. Verify the security on the endpoints, such as `/beans`.
3. To disable endpoints like `/health` and `/info`, refer to the next section.

# Conclusion

Securing Spring Boot Actuator endpoints is crucial to protect sensitive information from unauthorized access. In this guide, we covered the steps to add Spring Security to your project and secure the Actuator endpoints. By adding the `spring-boot-starter-security` dependency, you can easily prompt users for login credentials to access the endpoints.

We also explored how to override the default username and password, as well as exclude specific endpoints from being accessible to unauthorized users. Additionally, we mentioned that Spring Security can be further customized to utilize databases for roles and encrypted passwords.

By implementing the security measures outlined in this guide, you can ensure the protection of your Spring Boot Actuator endpoints and maintain the confidentiality of your application's information.