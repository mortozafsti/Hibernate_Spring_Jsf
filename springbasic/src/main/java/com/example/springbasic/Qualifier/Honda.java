package com.example.springbasic.Qualifier;

import org.springframework.stereotype.Component;

@Component(value = "HondaBean")
public class Honda implements Vehicle{

    @Override
    public void start() {
        System.out.println("Honda Started");
    }

    @Override
    public void stop() {
        System.out.println("Honda Stoped");
    }
}
