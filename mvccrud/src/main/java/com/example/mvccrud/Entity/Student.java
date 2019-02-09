package com.example.mvccrud.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2,max = 30)
    private String name;

    @Min(value = 18,message = "Hey Minimum age is 18")
    private byte age;

    @NotNull(message = "Select Your Gender")
    private String gender;

    @NotNull(message = "Select the Appropriate Course")
    private String c_complete;

    @NotNull(message = "Select Your Round")
    private String round;

    @NotNull(message = "Select Your Email")
    private String email;

    public Student() {
    }

    public Student(String name, byte age, String gender, String c_complete, String round, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.c_complete = c_complete;
        this.round = round;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getC_complete() {
        return c_complete;
    }

    public void setC_complete(String c_complete) {
        this.c_complete = c_complete;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
