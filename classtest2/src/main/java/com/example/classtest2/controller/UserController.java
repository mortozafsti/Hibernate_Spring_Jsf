package com.example.classtest2.controller;

import com.example.classtest2.entity.Role;
import com.example.classtest2.entity.User;
import com.example.classtest2.repo.RoleRepo;
import com.example.classtest2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping(value = "/user-save")
    public String saveUser(){

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1l));
        User user = new User("Mortoza", "sadmin", passwordEncoder.encode("1234"), "mortozafsti@gmail.com", true, roles);
        userRepo.save(user);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(new Role(2l));
        User user2 = new User("Milton", "admin",passwordEncoder.encode("12345"), "milton@gmail.com", true, roles2);
        userRepo.save(user2);

        Set<Role> roles3 = new HashSet<>();
        roles3.add(new Role(3l));
        User user3 = new User("Rakib", "user",passwordEncoder.encode("123456"), "rakib@gmail.com", true, roles3);
        userRepo.save(user3);

       return "success";

    }
}
