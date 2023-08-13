# Bean Lifecycle Methods in Spring

Welcome to this tutorial on Bean Lifecycle Methods in Spring. By the end of this guide, you'll gain a solid understanding of how beans are managed in Spring and how you can hook into their lifecycle to run your custom code.

## Table of Contents

- [Introduction](#introduction)
- [Purpose of Bean Lifecycle Methods](#purpose)
- [Development Process](#development)
- [Configuring Initialization and Destruction Methods](#configuring)
- [Prototype Beans: Caveats and Considerations](#prototype-beans)
    - [Destroy Lifecycle](#destroy-lifecycle)
    - [Lazy Initialization](#lazy-initialization)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

In the context of Spring, the term "bean" often refers to an object that forms the backbone of your application and is managed by the Spring IoC container. This guide dives deep into understanding the lifecycle of these beans.

When the Spring container starts:
- Beans are instantiated
- Dependencies are injected
- Internal Spring processing takes place
- Custom initialization methods are executed

When the Spring container stops:
- Custom destroy methods are invoked

## Purpose of Bean Lifecycle Methods

Bean lifecycle methods (often termed hooks) serve a significant role, allowing developers to:
- Inject custom initialization code
- Call specific business logic methods
- Set up resource handles like databases, sockets, and files
- Add custom code during bean destruction, such as cleaning up resources

## Development Process

1. Define methods for initialization (`init`) and destruction (`destroy`).
2. Apply `@PostConstruct` and `@PreDestroy` annotations to the respective methods.
3. Implement custom logic within these methods.
4. Start the Spring application and observe the lifecycle in action. When the application starts, the initialization method runs. On stopping the application, the destruction method is executed.

## Configuring Initialization and Destruction Methods

To illustrate, consider a class named `FootballCoach`. 

### Initialization

For the initialization phase:

```java
import javax.annotation.PostConstruct;

@Component
public class FootballCoach implements Coach{

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartopStuff(): " + getClass().getSimpleName());
    }
}
```

Here, the `@PostConstruct` annotation signals that `doMyStartupStuff()` should be executed after the bean is constructed.

### Destruction

Similarly, for the destruction phase:

```java
import javax.annotation.PreDestroy;

public class FootballCoach {

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }
}
```

In this instance, the `@PreDestroy` annotation indicates that `doMyCleanupStuff()` will be executed before the bean is destroyed.

## Prototype Beans: Caveats and Considerations

### Destroy Lifecycle

When it comes to "prototype" scoped beans, there's an essential distinction. Unlike other scopes, Spring doesn't oversee the entire lifecycle of prototype beans. Upon constructing, configuring, and assembling a prototype object, the container delivers it to the client. Beyond this point, Spring doesn't track that particular instance.

Consequently, initialization lifecycle callback methods are triggered on all beans, irrespective of their scope. However, for prototype beans, the configured destruction lifecycle callbacks aren't executed. The responsibility falls upon the client code to tidy up prototype beans and free any high-cost resources they utilize.

> **Note**: For "prototype" beans, the destroy method isn't invoked by Spring. An essential distinction!

### Lazy Initialization

Prototype beans inherently follow a "lazy" pattern, only initializing when explicitly requested. There's no necessity to tag them with the `@Lazy` annotation.

## Conclusion

Spring's bean lifecycle methods provide a robust mechanism for developers to interject custom code at crucial stages of a bean's existence, from initialization to destruction. With the power of annotations like `@PostConstruct` and `@PreDestroy`, you can seamlessly manage resources and ensure the smooth operation of your beans throughout their lifecycle.

## References

- [Spring Official Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-lifecycle)
- [Java Annotations](https://docs.oracle.com/javase/tutorial/java/annotations/)

Happy coding! 🌱