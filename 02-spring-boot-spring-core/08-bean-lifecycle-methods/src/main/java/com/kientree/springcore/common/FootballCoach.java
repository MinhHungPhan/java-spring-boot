package com.kientree.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    public FootballCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartopStuff(): " + getClass().getSimpleName());
    }

    // Define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Incorporate ladder drills to improve your footwork and agility on the field";
    }
}
