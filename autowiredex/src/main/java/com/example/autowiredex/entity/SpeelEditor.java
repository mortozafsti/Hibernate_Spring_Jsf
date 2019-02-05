package com.example.autowiredex.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class SpeelEditor {
    @Autowired
    private TextEditor textEditor;

    public void spelEditor(){
        textEditor.speelCheck();
    }
}
