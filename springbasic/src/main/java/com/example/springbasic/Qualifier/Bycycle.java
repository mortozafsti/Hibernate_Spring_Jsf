package com.example.springbasic.Qualifier;

import org.springframework.stereotype.Component;

@Component(value = "Bycycle")
public class Bycycle implements Vehicle{

    @Override
    public void start() {
        System.out.println("Bycycle Started");
    }

    @Override
    public void stop() {
        System.out.println("Bycycle Stoped");
    }
}
