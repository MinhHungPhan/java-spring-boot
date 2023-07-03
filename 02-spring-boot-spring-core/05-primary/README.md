# Primary Annotation

## Table of Contents

- [Introduction](#introduction)
- [The Qualifier Annotation](#the-qualifier-annotation)
- [Introducing the Primary Annotation](#introducing-the-primary-annotation)
- [Demo: Using the Primary Annotation](#demo-using-the-primary-annotation)
- [Using Primary and Qualifier Together](#using-primary-and-qualifier-together)
- [Which One to Use?](#which-one-to-use)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

In the context of Spring Framework, resolving the issue of multiple bean implementations can be challenging for beginners. This guide is intended to make this process more manageable by explaining the use of two key annotations: `@Qualifier` and `@Primary`.

## The Qualifier Annotation

In [the previous tutorial](/02-spring-boot-spring-core/04-qualifiers/README.md), we used the `@Qualifier` annotation to specify a particular bean when there were multiple options available. For example, if we had different types of coaches (`TrackCoach`, `BaseballCoach`, `TennisCoach`, `CricketCoach`), we could specify which coach we wanted by using their name:

```java
public class CoachController {
    private Coach myCoach;

    @Autowired
    public CoachController(@Qualifier("tennisCoach") Coach theCoach){
        myCoach = theCoach;
    }
}
```
This approach is efficient but can be quite explicit and may not be suitable if you simply need a coach without specifying which one.

## Introducing the Primary Annotation

Spring introduces another solution with the `@Primary` annotation. This allows you to define a primary bean that will be the default choice if no specific `@Qualifier` is specified. You simply assign the `@Primary` annotation to the preferred bean implementation:

```java
@Component
@Primary
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice forehand topspin for 30 minutes";
    }
}
```

In this example, if multiple coaches are available and none is explicitly mentioned, `TennisCoach` will be used as the default because it's marked with the `@Primary` annotation.

## Demo: Using the Primary Annotation

Here is how you would use this in a constructor injection with our `CoachController`:

```java
@RestController
public class CoachController {

    private Coach myCoach;

    @Autowired
    public CoachController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
```

In this case, `theCoach` would be an instance of `TennisCoach` as it's declared as the `@Primary` bean.

## Using Primary and Qualifier Together

You might be wondering if it's possible to use both `@Primary` and `@Qualifier` in the same class. The answer is yes. However, be aware that `@Qualifier` takes precedence over `@Primary`. So, even if you declare `TrackCoach` as `@Primary`, if `@Qualifier("cricketCoach")` is specified, `CricketCoach` will be used instead.

## Which One to Use?

So, which should you use? `@Primary` or `@Qualifier`? While `@Primary` leaves the decision up to the implementation classes, you might encounter issues if multiple primary classes are declared, leading to an error. On the other hand, `@Qualifier` allows you to be very specific about which bean you want. Generally, using `@Qualifier` is recommended due to its specificity and higher priority compared to `@Primary`.

## Conclusion

Working with multiple bean implementations in Spring can initially seem complicated, but with the help of `@Qualifier` and `@Primary` annotations, you can efficiently manage your beans. Remember, `@Qualifier` lets you specify the exact bean you need, while `@Primary` allows you to set a default option when no specific bean is requested.

## References

- [@Qualifier Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Qualifier.html)
- [@Primary Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Primary.html)
