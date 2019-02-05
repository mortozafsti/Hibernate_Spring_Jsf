package com.example.autowiredex.entity;

import org.springframework.context.annotation.Configuration;


public class SpeelChecker {

    public SpeelChecker() {
        System.out.println("Inside speelChecker Constructor");
    }
    public void checkSpeel(){
        System.out.println("Inside SpeelCheck");
    }

}
