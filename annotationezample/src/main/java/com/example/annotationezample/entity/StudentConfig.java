package com.example.annotationezample.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean(name = "student")
    public Student getStudent(){
        Student student = new Student(102,"Mortoza");
        return student;
    }

    @Bean(name = "studentsetter")
    public Student getStudentBySetter(){
        Student student = new Student();
        student.setId(105);
        student.setName("Milton");
        return student;
    }
}
