package com.kientree.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/kientree")
public class RestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
