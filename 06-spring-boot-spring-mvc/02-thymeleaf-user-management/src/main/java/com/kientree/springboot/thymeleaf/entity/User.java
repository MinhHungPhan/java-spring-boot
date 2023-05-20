package com.kientree.springboot.thymeleaf.entity;

public class User {
    private String name;
    private String email;

    // Define constructors

    public User() {

    }
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Define Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Define toString

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
