package com.kientree.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice forehand topspin for 30 minutes";
    }
}
