package com.example.diconstructor.entity;

public class Address {

    private String state;
    private String city;
    private String country;

    public Address(String state, String city, String country) {
        this.state = state;
        this.city = city;
        this.country = country;
    }

    public String toString(){
        return state +" "+city+" "+country;
    }
}
