package com.example.autowiredex.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

    @Autowired
    private SpeelChecker speelChecker;

    public void speelCheck(){
        speelChecker.checkSpeel();
    }
}
