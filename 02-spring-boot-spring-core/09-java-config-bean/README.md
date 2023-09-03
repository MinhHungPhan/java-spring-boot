# Configuring Beans with Java Code in Spring

In this tutorial, we'll delve deep into how we can configure beans in a Spring application using Java code instead of annotations.

## Table of Contents

- [Introduction](#introduction)
- [Development Process](#development-process)
- [Use Case for the `@Bean` Annotation](#use-case-for-the-bean-annotation)
- [Real-World Example](#real-world-example)
- [Hands-On](#hands-on)
  - [Setting up a Configuration Class](#setting-up-the-configuration-class)
  - [Defining a Bean Method](#defining-a-bean-method)
  - [Injecting beans into the Controller](#injecting-beans-into-controllers)
  - [Custom Bean IDs](#custom-bean-ids)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

Typically in Spring, we use annotations to declare a class as a component. However, there may be instances where we prefer or need to configure a bean through Java code. In this tutorial, we will introduce a `SwimCoach` that adheres to the `Coach` interface but will not use annotations directly on the class.

## Development Process

1. **Creating a Configuration Class**

Our first step is to establish a configuration class. A configuration class in Spring is a means to programmatically define beans.

```java
@Configuration
public class SportConfig {
    // ...
}
```

2. **Defining a Bean Method**

To define beans, the `@Bean` annotation is employed in the configuration class. This way, we manually construct the object and return its instance.

```java
@Bean
public Coach swimCoach() {
    return new SwimCoach();
}
```

By default, the bean ID is the method name, so in this case, the bean ID would be `swimCoach`.

3. **Injecting the Bean into the Controller**

Once the bean is defined, we can inject it into our controller. If you wish to specify which bean should be autowired, the `@Qualifier` annotation, combined with the bean ID, is used.

```java
@Autowired
public CoachController(@Qualifier("aquatic") Coach theCoach){
    System.out.println("In constructor: " + getClass().getSimpleName());
    myCoach = theCoach;
}
```

## Use Case for the `@Bean` Annotation

You might be wondering, why not just utilize the `@Component` annotation directly? While feasible for classes we've created, sometimes, we want to integrate a third-party class into our Spring application. The primary motive behind the `@Bean` annotation is to make third-party classes, which we might not have source access to, available as Spring beans.

## Real-World Example

Consider working with Amazon's Simple Storage Service (S3). AWS S3 is a cloud storage solution, and let's say we want to use its client as a Spring bean. The AWS S3 client is part of the AWS SDK, which we can't modify directly. Yet, we can expose it as a Spring bean via the `@Bean` annotation.

```java
@Configuration
public class DocumentsConfig {

    @Bean
    public S3Client remoteClient() {
        
        // Create an S3 client to connect to AWS S3
        ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create();
        Region region = Region.US_EAST_1;
        S3Client s3Client = S3Client.builder()
                .region(region)
                .credentialsProvider(credentialsProvider)
                .build();
                
        return s3Client;
    }
}
```

Later, we can autowire the S3 client into any Spring component or service.

```java
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.S3Client;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DocumentsService {

    private S3Client s3Client;

    @Autowired
    public DocumentsService(S3Client s3Client) {
        this.s3Client = s3Client;
    }
}
```

## Hands-On

### Setting up the Configuration Class

To kick things off, let's set up a configuration class:

1. Create a separate package for configurations. For example, in our demo, we'll use `config`.
2. Inside this package, create a new class, which in our case is `SportConfig`.
3. Annotate this class with `@Configuration`. Make sure you're using the `Configuration` annotation and not `Configurable`.

```java
@Configuration
public class SportConfig {
    //... further configurations will be added here
}
```

### Defining a Bean Method

Now, let's define a Spring bean inside the `SportConfig` class:

1. Use the `@Bean` annotation above a method.
2. The method should return an instance of the desired bean. For our example, it's `SwimCoach`.

```java
@Bean
public Coach swimCoach() {
    return new SwimCoach();
}
```

Here, the default bean ID will be the method name, i.e., `swimCoach`.

### Injecting Beans into Controllers

With the bean defined, it can be easily injected into other parts of the application like controllers. For instance, we have have a `CoachController` that requires a `SwimCoach`, Spring will automatically provide it.

```java
@RestController
public class CoachController {

    private Coach myCoach;

    @Autowired
    public CoachController(@Qualifier("swimCoach") Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){return myCoach.getDailyWorkout();
    }
}
```

When you run the application, you should see logs indicating the creation of `SwimCoach`, proving that it was properly configured.

### Custom Bean IDs

If the default bean ID (which is the method name) doesn't suit your needs, you can set a custom ID:

```java
@Bean("aquatic")
public Coach swimCoach() {
    return new SwimCoach();
}
```

With this configuration, the bean ID is now `aquatic`. In your controllers or other parts of the application, you can reference this bean using the custom ID.

```java
@RestController
public class CoachController {

    private Coach myCoach;

    @Autowired
    public CoachController(@Qualifier("aquatic") Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){return myCoach.getDailyWorkout();
    }
}
```

## Conclusion

Through this tutorial, you've witnessed the power of Java-based configuration in Spring. While annotations like `@Component` are immensely helpful, the `@Bean` annotation offers flexibility, especially when integrating third-party classes.

Thank you for following along. In the next segment, we'll explore further practical applications of the `@Bean` annotation. See you in the next tutorial!

## References

- [Spring Official Documentation : @Bean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html)
- [AWS SDK for Java: S3Client](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/examples-s3.html)