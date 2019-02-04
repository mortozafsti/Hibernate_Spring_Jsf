package com.example.annotationezample.Test;


import com.example.annotationezample.entity.Student;
import com.example.annotationezample.entity.StudentConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Testa {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);

        Student student = (Student) context.getBean("student");
        System.out.println(student);

        Student student1 = (Student) context.getBean("studentsetter");
        System.out.println(student1);

    }

}
