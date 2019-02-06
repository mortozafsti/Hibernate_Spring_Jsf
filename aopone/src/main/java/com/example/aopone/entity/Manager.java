package com.example.aopone.entity;

public class Manager {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("In set Method");
    }
}
