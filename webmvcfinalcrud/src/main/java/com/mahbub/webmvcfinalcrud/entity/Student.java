package com.mahbub.webmvcfinalcrud.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student4")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 20, message = "Enter Your Name")
    private String name;

    @NotBlank(message = "Enter Your Gender")
    private String gender;

    public Student() {
    }

    public Student(@NotNull @Size(min = 2, max = 20, message = "Enter Your Name") String name, @NotBlank(message = "Enter Your Gender") String gender) {
        this.name = name;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
