package com.example.hellomvaproject.Controller;

import com.example.hellomvaproject.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    static List<Student> list;
    static {
        list = new ArrayList<>();
        list.add(new Student(1L,"Mortoza","cse"));
        list.add(new Student(2L,"Shakil","Chemisty"));
        list.add(new Student(3L,"Mahabub","Math"));
        list.add(new Student(4L,"Kalam","Physics"));
        list.add(new Student(5L,"Munna","mba"));
    }

    @GetMapping(value = "/shome")
    public String studentHome(){
        return "Hellow Student";
    }

    @GetMapping(value = "/slist")
    public List<Student> getStudentList(){
        return this.list;
    }

    @GetMapping(value = "/suser")
    public Student getStudent(){
        return new Student(5L,"Uddin","Social Science");
    }
    @GetMapping(value = "/suser/{s_name}")
    public Student getStudentByName(@PathVariable("s_name") String name){
        Student student = null;
        for(Student s : this.list){
        if (name == s.getS_name()){
            student = new Student();
            student = new Student(s.getId(),s.getS_name(),s.getS_dept());
        }
        }
        return student;
    }

}
