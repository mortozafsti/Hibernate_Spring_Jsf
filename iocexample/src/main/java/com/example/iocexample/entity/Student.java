package com.example.iocexample.entity;

public class Student {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void show(){
//        Student student = new Student();
//        student.setName("G M Mortoza Ahmed");
        setName("Kalam Uddin John");
        System.out.println("Hello "+name);
    }
}
