package com.example.classtest2.controller;

import com.example.classtest2.entity.Role;
import com.example.classtest2.entity.User;
import com.example.classtest2.repo.RoleRepo;
import com.example.classtest2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "/user-save")
    public void saveUser(){

        Set<Role> roles = new HashSet<>();
        roles.add(new Role("SUPERADMIN"));
        roles.add(new Role("USER"));
        User user = new User("Mortoza", "sadmin", "12345", "mortozafsti@gmail.com", true, roles);
        userRepo.save(user);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(new Role("ADMIN"));
        User user2 = new User("Milton", "admin", "1234", "milton@gmail.com", true, roles2);
        userRepo.save(user2);

        System.out.println("User Successfully Saved");

    }
}
