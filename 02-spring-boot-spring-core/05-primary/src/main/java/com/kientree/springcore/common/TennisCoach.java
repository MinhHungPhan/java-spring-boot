package com.kientree.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice forehand topspin for 30 minutes";
    }
}
