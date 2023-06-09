# Component Scanning with Spring

In this guide, we'll discuss component scanning in Spring. Spring scans Java classes annotated with certain annotations, such as `@Component`, and automatically registers these as beans in the Spring container.

## An Overview of the Spring Boot Application

The `@SpringBootApplication` annotation is a convenience annotation that adds all of the following:

- `@EnableAutoConfiguration`: Enables Spring Boot's auto-configuration support.
- `@ComponentScan`: Enables component scanning in the current package and its sub-packages.
- `@Configuration`: Enables the class to register extra beans with `@Bean` or import other configuration classes.

In simpler terms, `@SpringBootApplication` combines these three annotations, streamlining the configuration and bootstrapping of your Spring Boot application.

```java
@SpringBootApplication
public class SpringcoredemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }
}
```

The `SpringApplication.run()` method bootstraps the Spring Boot application, creating an application context, registering all the beans, and starting an embedded server (such as Tomcat) by default.

## Understanding Component Scanning

Spring Boot initiates component scanning from the package where your main Spring Boot application resides and scans recursively through its sub-packages. This implicit behavior defines a base search package, allowing the default component scanning without having to explicitly reference the base package name.

The Main Spring Boot application class automatically starts component scanning at the class level and recursively through all its sub-packages.

Component scanning automatically picks up components (`@Component`, `@Service`, `@Repository`, `@Controller`, etc.) and creates beans for them in the application context, allowing Spring to automatically wire up the dependencies.

## Common Pitfall with Component Scanning

A common pitfall is to place your main application class in the default package or mismatch the package structure, causing some beans not to be picked up.

Spring Boot will not scan for components outside the package and its sub-packages where your main Spring Boot application class is located. This default behavior is usually sufficient, as long as you've structured your code correctly.

```bash
com
+-- mycompany
    +-- Application.java (annotated with @SpringBootApplication)
    +-- customer
        +-- CustomerController.java (annotated with @Controller)
    +-- product
        +-- ProductService.java (annotated with @Service)
    +-- order
        +-- OrderRepository.java (annotated with @Repository)
```

## Customizing Component Scan

If you choose to restructure your project by creating packages outside of your main application class's package, Spring Boot will not component scan these external packages. It will only scan the main application class package and its sub-packages. However, if you wish to include other packages for scanning, you can do so by explicitly specifying these packages in your Spring Boot application annotation.

```java
@SpringBootApplication
@ComponentScan(basePackages = {"com.mycompany.customer", "com.mycompany.product", "com.mycompany.order"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

In the above example, we've provided a comma-separated list of packages to `basePackages` attribute of `@ComponentScan` to include them in the component scan process.