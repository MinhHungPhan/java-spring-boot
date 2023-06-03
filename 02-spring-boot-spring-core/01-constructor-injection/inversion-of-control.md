# Inversion of Control in Spring

This guide explores the concept of Inversion of Control (IoC) in the context of Spring. IoC is an approach where the construction and management of objects are outsourced to another entity, rather than manually creating objects ourselves. In Spring, the IoC container acts as an object factory, creating and managing objects based on configuration and providing references to these objects.

## Table of Contents
- [Introduction to Inversion of Control](#introduction-to-inversion-of-control)
- [The Need for Configurability](#the-need-for-configurability)
- [The Role of the Spring Container](#the-role-of-the-spring-container)
- [Configuring the Spring Container](#configuring-the-spring-container)
- [Conclusion](#conclusion)

## Introduction to Inversion of Control

Inversion of Control (IoC) is a design principle that promotes the outsourcing of object construction and management. Instead of directly creating objects within our application, we delegate this responsibility to an external entity, which in turn provides us with the necessary objects when needed.

Here is the diagram for Inversion of Control in Spring:


## The Need for Configurability

Consider an application where we have a `CricketCoach` class. We want to call a method on `CricketCoach` to get a daily workout. However, we also want the flexibility to easily switch the coach for another sport, such as baseball, hockey, tennis, gymnastics, and so on. We desire a configurable application where we can request a coach for a workout and receive the appropriate response based on the configured sport.

## The Role of the Spring Container

The Spring container serves as the IoC container and acts as an object factory. We can communicate with the Spring container and request a coach object. Based on the configuration, the container creates the required coach object, whether it's a `CricketCoach`, a hockey coach, or a baseball coach, and provides us with a reference to that coach object.

## Configuring the Spring Container

To configure the Spring container, we have multiple approaches at our disposal:

1. XML Configuration (Legacy): We won't cover this approach in this guide, as it is considered legacy.

2. Java Annotations: We can leverage annotations such as `@Component`, `@Autowired`, and others to configure the container using annotations.

3. Java Source Code: We can configure the container using Java source code, making use of classes like `@Configuration`, `@Bean`, and other related annotations.

In this guide, we focus on the modern solutions of Java annotations and Java source code for configuring the Spring container. These approaches provide more flexibility and are widely used in Spring applications.

## Conclusion

Inversion of Control (IoC) is a fundamental concept in Spring, allowing us to delegate object creation and management to the Spring container. By configuring the container using Java annotations or Java source code, we can achieve a highly configurable and flexible application. Embrace the power of IoC and the Spring container to simplify object management and enhance the modularity and maintainability of your Spring applications.
