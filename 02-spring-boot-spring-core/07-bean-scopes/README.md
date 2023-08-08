# Bean Scopes in Spring

## Table of Contents

- [Introduction](#introduction)
- [Understanding Scopes](#understanding-scopes)
- [Singleton Scope](#singleton-scope)
- [Other Scopes](#other-scopes)
- [Prototype Scope Example](#prototype-scope-example)
- [Checking the Bean Scope](#checking-the-bean-scope)
- [Conclusion](#conclusion)
- [References](#references)

## Introduction

In Spring, the lifecycle and persistence of a bean is referred to as its "scope". This guide will help you understand the various scopes available in Spring and how to utilize them effectively.

## Understanding Scopes

- **Scope** is an attribute of a Spring bean which determines its lifecycle and persistence.
- It dictates:
  - Duration of the bean's existence.
  - Number of instances created.
  - How the bean is shared among other objects.

## Singleton Scope

- **Singleton** is the default bean scope in Spring.
- Only one instance of the bean is created by the Spring Container.
- This instance is cached in memory.
- Every injection of this bean will reference the same instance.

**Example:**

```java
@RestController
public class CoachController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public CoachController(
            @Qualifier("footballCoach") Coach theCoach,
            @Qualifier("footballCoach") Coach theanotherCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theanotherCoach;
    }
```

Here, both `myCoach` and `anotherCoach` will point to the same `FootballCoach` instance, since the default scope is singleton.

## Other Scopes

- **Prototype**: A new bean instance is created for each container request or injection point.
- **Request**: The bean is scoped to an HTTP web request. (For web applications only)
- **Session**: The bean is scoped to an HTTP web session. (For web applications only)
- **Global Session**: The bean is scoped to a global HTTP web session. (For web applications only)

## Prototype Scope Example

To explicitly define a bean's scope, you can use the `@Scope` annotation.

**Example:**

```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach{

    public FootballCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Incorporate ladder drills to improve your footwork and agility on the field";
    }
}
```

In the context of our `CoachController`, if `FootballCoach` has a prototype scope, `myCoach` and `anotherCoach` will each point to different instances of `FootballCoach`.

## Checking the Bean Scope

To verify the scope of a bean, we can compare references of injected beans.

**Example:**

```java
@GetMapping("/check")
public String check(){
    return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
}
```

For a singleton scope, this would return `true`, but for a prototype scope, this would return `false`.

## Conclusion

Understanding bean scopes in Spring is fundamental for effective application development. The choice of scope can impact application behavior, performance, and memory usage. Always make a conscious decision about the scope of your beans based on your application's requirements. Happy coding!

## References

- [Official Spring Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes)
- [Spring Framework: Bean Scopes](https://www.baeldung.com/spring-bean-scopes)

