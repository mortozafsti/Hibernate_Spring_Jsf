package com.example.hellomvaproject.Entity;

public class Student {

    private Long id;
    private String s_name;
    private String s_dept;

    public Student() {
    }

    public Student(Long id, String s_name, String s_dept) {
        this.id = id;
        this.s_name = s_name;
        this.s_dept = s_dept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_dept() {
        return s_dept;
    }

    public void setS_dept(String s_dept) {
        this.s_dept = s_dept;
    }
}
