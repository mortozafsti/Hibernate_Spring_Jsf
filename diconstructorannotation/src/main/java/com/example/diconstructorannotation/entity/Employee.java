package com.example.diconstructorannotation.entity;

public class Employee {

    private int id;
    private String name;
    private Address address;

    public Employee() {
        System.out.println("This is Milton");
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, Address address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void show(){
        System.out.println("Id: "+id +" Name: "+ name);
        System.out.println("Address: "+address);
    }
}
