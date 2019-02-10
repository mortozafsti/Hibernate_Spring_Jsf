package com.example.springevidence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name = "studentone")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2,max = 6,message = "Name at Least 2 Char")
    private String name;

    @NotBlank(message = "Enter Your Email")
    private String email;

    @NotBlank(message = "Enter Your Phone")
    private String phone;

    @Min(value = 18,message = "You age is required")
    private String age;

    @NotBlank(message = "Enter Your Gender")
    private String gender;

    @NotBlank(message = "Enter Your Course")
    private String c_course;

    @NotBlank(message = "Enter Your Round")
    private String round;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date regiDate;

    public Student() {
    }

    public Student(@NotNull String name, @NotNull String email, @NotNull String phone, @NotNull String age, @NotNull String gender, @NotNull String c_course, @NotNull String round, Date regiDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.c_course = c_course;
        this.round = round;
        this.regiDate = regiDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getC_course() {
        return c_course;
    }

    public void setC_course(String c_course) {
        this.c_course = c_course;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }
}
