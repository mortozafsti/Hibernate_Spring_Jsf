package com.example.beanlifecycle.entity;

public class SimpleBean {

    private final String DEFAULT_NAME="Mortoza";
    private String name = null;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "SimpleBean{" +
                "DEFAULT_NAME='" + DEFAULT_NAME + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void init(){
        System.out.println("Initializing Bean");
        if (name == null){
            System.out.println("Using Default namr");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE){
            throw  new IllegalArgumentException("You must be Attend Bean Life Cycle Session"+SimpleBean.class);
        }
    }
}
