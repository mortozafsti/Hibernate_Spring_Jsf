package com.example.classtest2.controller;

import com.example.classtest2.entity.User;
import com.example.classtest2.repo.RoleRepo;
import com.example.classtest2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/profile")
    public String profileView(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",authentication.getName());
        User user = this.userRepo.findByUsername(authentication.getName());
        model.addAttribute("name",user.getName());
        model.addAttribute("user",user);

        model.addAttribute("rolelist",this.roleRepo.findAll());

        return "profile";
    }
}
