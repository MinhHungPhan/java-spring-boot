package com.kientree.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Incorporate ladder drills to improve your footwork and agility on the field";
    }
}
