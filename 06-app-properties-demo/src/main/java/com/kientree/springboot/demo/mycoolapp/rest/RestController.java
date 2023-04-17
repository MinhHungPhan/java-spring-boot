package com.kientree.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    // Inject properties for: president.name and company.name

    @Value("${president.name}")
    private String presidentName;

    @Value("${company.name}")
    private String companyName;

    // Expose new endpoint for "companyinfo"

    @GetMapping("/companyinfo")
    public String getCompanyInfo(){
        return "President: " + presidentName + ", company name: " + companyName;
    }


    // Handle GET request to "/hello" endpoint
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Expose a new endpoint for "pingpong"
    @GetMapping("/pingpong")
    public String playPingPong() {
        return "Play ping pong with my girlfriend";
    }

    // Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5 km with my girlfriend";
    }
}
