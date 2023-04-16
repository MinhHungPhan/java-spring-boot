package com.kientree.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    // Your methods will go here

    // Handle GET request to "/hello" endpoint
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // expose a new endpoint for "pingpong"
    @GetMapping("/pingpong")
    public String playPingPong() {
        return "Play ping pong with my girlfriend";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5 km with my girlfriend";
    }
}
