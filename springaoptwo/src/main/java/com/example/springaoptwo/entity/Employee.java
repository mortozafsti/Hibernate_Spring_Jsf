package com.example.springaoptwo.entity;

public class Employee {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printNameId(){
        System.out.println("My name is: " + name + " and My Id is: " + id);
    }
    public void checkName(){
        if (name.length() < 20){
            throw  new IllegalArgumentException();
        }
    }
    public void sayHeloo(String message){
        System.out.println("This isMethos is SayHello: " + message);
    }
}
