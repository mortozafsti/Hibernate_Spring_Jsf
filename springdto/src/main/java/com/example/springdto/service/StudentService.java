package com.example.springdto.service;

import com.example.springdto.dto.StudentDTO;
import com.example.springdto.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public void saveOrUpdate(StudentDTO studentDTO);

    public void deleteById(Long id);

    public Student findbyId(Long id);

    public List<StudentDTO> getAll();


    Student findByEmailAddress(String email);

    long countNoOfStudent(String email);


}
