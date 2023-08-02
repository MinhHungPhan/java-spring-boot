# Lazy Initialization in Spring Boot

## Table of Contents

- [Introduction](#introduction)
- [Understanding Lazy Initialization](#understanding-lazy-initialization)
- [Configuring Lazy Initialization](#configuring-lazy-initialization)
   * [Using Annotations](#using-annotations)
   * [Global Configuration](#global-configuration)
- [Advantages and Disadvantages](#advantages-and-disadvantages)
- [Practical Coding Example](#practical-coding-example)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

In a Spring Boot application, the initialization of beans is an essential part of the startup process. However, in some scenarios, eager initialization of all beans might not be optimal. That's where lazy initialization comes into play.

This tutorial covers the concept of lazy initialization, how to configure it, and a hands-on coding example to illustrate the concepts.

## Understanding Lazy Initialization

By default, when your Spring Boot application starts, all beans are initialized, and instances of each bean are made available. But what if you want to delay this initialization until the bean is actually required? Lazy initialization is the answer.

### Regular Initialization

Without lazy initialization, Spring will scan for all components, and all those components will be initialized. It's like calling everyone into the meeting, whether or not they are required. You can monitor this by adding print statements to the constructors of your classes.

For example:

```java
@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!";
    }
}
```

When starting the application, you'll see log messages for each bean, indicating their initialization. We cab notice that all beans are created at application startup.

Output:

```plaintext
In constructor: BasketballCoach
In constructor: CricketCoach
In constructor: FootballCoach
In constructor: TennisCoach
```

### Lazy Initialization

With lazy initialization, beans will only be initialized in the following cases:
* when it's needed for a dependency injection,
* or it is explicitly requested.

To make use of lazy initialization, you simply add the `@Lazy` annotation to a given class.

## Configuring Lazy Initialization

### Using Annotations

For individual classes, you can use the `@Lazy` annotation. Here's an example:

```java
@Component
@Lazy
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice forehand topspin for 30 minutes";
    }
}
```

### Global Configuration

For large projects, it can be tedious to annotate each class with `@Lazy`. Fortunately, you can enable lazy initialization across the board by setting the following property in your `application.properties` file:

```properties
spring.main.lazy-initialization=true
```

## Advantages and Disadvantages

### Advantages:

* Objects are created only as needed.
* Faster startup time if you have a large number of components.

### Disadvantages:

* Web-related components like RestController will not be created until requested.
* May not discover configuration issues until too late.
* Need to ensure enough memory for all beans once created.

## Practical Coding Example

Here's a walkthrough of implementing lazy initialization with a coding example:

1. **Setup**: Start with the regular initialization and add print statements to the constructors for diagnostics.
2. **Mark as Lazy**: Use the `@Lazy` annotation for specific classes, such as `TennisCoach`.
3. **Global Configuration**: Add the global property in `application.properties` to make all beans lazy.
4. **Testing**: Run the application and observe the logs to understand which beans are initialized when.

### Example Output:

With lazy initialization, you'll notice the print line statements only for the beans that are explicitly needed. `TennisCoach` is not displayed because it's been marked as `@lazy`.

Output:

```plaintext
In constructor: BasketballCoach
In constructor: CricketCoach
In constructor: FootballCoach
```

## Conclusion

Lazy initialization is a powerful feature in Spring Boot that allows you to optimize the startup process by initializing beans only when they are required. It's essential to carefully evaluate the needs of your application before implementing lazy initialization, and avoid premature optimization.

This tutorial provided a clear understanding of the concept and practical techniques to apply lazy initialization, with both individual annotations and global configuration.

## References

* [Spring Framework Documentation - Lazy Initialization](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-lazy-init)
* [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

Now you have the knowledge to utilize lazy initialization to enhance your Spring Boot applications. Good job, my friend!