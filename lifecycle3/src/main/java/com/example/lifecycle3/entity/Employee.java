package com.example.lifecycle3.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init(){
        System.out.println("This is init method");
    }
    @PreDestroy
    public void clear(){
        System.out.println("This is Clean Up method");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
