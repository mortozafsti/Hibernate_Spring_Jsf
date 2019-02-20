package com.example.classtest2.controller;

import com.example.classtest2.entity.User;
import com.example.classtest2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private UserRepo userRepo;

    @ResponseBody
    @GetMapping(value = "/test")
    public User restApi(){
        return userRepo.findByUsername("admin");
    }
}
