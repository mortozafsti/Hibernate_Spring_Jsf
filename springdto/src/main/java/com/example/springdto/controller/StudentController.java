package com.example.springdto.controller;

import com.example.springdto.dto.StudentDTO;
import com.example.springdto.dto.StudentDTOReport;
import com.example.springdto.entity.Student;
import com.example.springdto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping(value = "/test/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.findbyId(id);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public List<StudentDTO> getStudents(){
        return studentService.getAll();
    }


    @GetMapping(value = "/report")
    @ResponseBody
    public List<StudentDTOReport> getReport(){
        Map<String, Long> maps = new HashMap<>();
        for (StudentDTO studentDTO : studentService.getAll()){
            maps.put(studentDTO.getEmail(),studentService.countNoOfStudent(studentDTO.getEmail()));
        }

        List<StudentDTOReport> list = new ArrayList<>();
        for (Map.Entry<String,Long> s : maps.entrySet()){
            list.add(new StudentDTOReport(s.getValue(),s.getKey()));
        }

        return list;
    }
}
