package com.kientree.springboot.thymeleaf.controller;

import com.kientree.springboot.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("users", users);
        return "index";
    }
}
