package com.kientree.springcore.rest;

import com.kientree.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    // Define a private filed for the dependency

    private Coach myCoach;


    @Autowired
    public CoachController(
            @Qualifier("aquatic") Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){return myCoach.getDailyWorkout();
    }


}
