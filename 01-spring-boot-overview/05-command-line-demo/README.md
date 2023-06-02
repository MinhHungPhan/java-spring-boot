# Running Spring Boot from Command Line

This guide provides instructions on how to run a Spring Boot application from the command line. It covers two options: using `java -jar` and the Spring Boot Maven Plugin. You will learn how to package and run your Spring Boot application outside of an IDE, making it self-contained and easily deployable.

## Table of Contents
- [Introduction](#introduction)
- [Option 1: Using `java -jar`](#option-1-using-java--jar)
- [Option 2: Using the Spring Boot Maven Plugin](#option-2-using-the-spring-boot-maven-plugin)
- [Development Process](#development-process)
- [Conclusion](#conclusion)

## Introduction

During the development of Spring Boot applications, most of our time is spent within the Integrated Development Environment (IDE). However, there are instances where we need to run our applications outside of the IDE. Running from the command line offers a convenient approach for executing Spring Boot applications independently, without the need for the IDE or a separate server installation.

In this guide, we will explore two options for running Spring Boot applications from the command line. The first option involves using the `java -jar` command, while the second option utilizes the Spring Boot Maven Plugin. By following these instructions, you will be able to effectively run your Spring Boot applications without relying on the IDE.

## Option 1: Using `java -jar`

When running a Spring Boot application from the command line, there is no need to keep the IDE open and running. Since the server is embedded within the JAR file, there is no requirement for a separate server installation such as Tomcat. Spring Boot applications are self-contained, including the server.

To run a Spring Boot application using the `java -jar` command:

1. Build your Spring Boot project by running `mvnw package` (or `mvn package` if you have Maven installed).

2. Navigate to the target directory where the JAR file is located.

3. Open a terminal or command prompt in that directory.

4. Execute the following command:
```bash
java -jar mycoolapp.jar
```

Replace `mycoolapp.jar` with the actual name of your JAR file.

The application will start up, and the server will be up and running. You can now access your Spring Boot application.

## Option 2: Using the Spring Boot Maven Plugin

The Spring Boot Maven Plugin provides additional capabilities for packaging and running Spring Boot applications. This option eliminates the need for manual installation of Maven.

To run a Spring Boot application using the Spring Boot Maven Plugin:

1. Ensure that you have the `mvnw` (for Windows) or `mvnw.sh` (for Linux/Mac) files in your project directory. If not, you can generate them using the Spring Initializer.

2. Open a terminal or command prompt in your project directory.

3. To package the application, run the command:

```bash
./mvnw package
```

This will create an executable JAR file or WAR file, depending on your configuration.

4. To run the application using the Spring Boot Maven Plugin, execute the following command:

```bash
./mvnw spring-boot:run
```

Alternatively, if you have Maven installed, you can use the following command:

```bash
mvn spring-boot:run
```

These commands will start the application, and you can access it through the specified server.

## Development Process

To better understand the process, follow these steps:

1. Exit the IDE and navigate to your project directory in the command line.

2. Package the application using `mvnw package` (or `mvn package` if Maven is installed).

3. Run the application using `java -jar mycoolapp.jar`.

4. Return to the project directory and run the application using the Spring Boot Maven Plugin: `mvnw spring-boot:run` (or `mvn spring-boot:run`).

By exploring both options, you can gain a comprehensive understanding of running Spring Boot applications from the command line.

## Conclusion

Running Spring Boot applications from the command line provides a convenient way to execute your applications independently of the IDE. Whether you choose to use the `java -jar` command or the Spring Boot Maven Plugin, you can easily package and run your applications with ease. By following the instructions provided in this guide, you can confidently deploy and test your Spring Boot applications in various environments.

