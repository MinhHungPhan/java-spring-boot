package com.kientree.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Perform the three-point shot 100 times in practice";
    }
}
