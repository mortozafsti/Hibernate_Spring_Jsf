package com.example.classtest2.controller;

import com.example.classtest2.entity.User;
import com.example.classtest2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "/adm")
    public String AdminView(){
        return "admin/admin";
    }

    @GetMapping(value = "/sa")
    public String superAdminView(){
        return "sadmin/sadmin";
    }

    @GetMapping(value = "/se")
    public String secureView(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",authentication.getName());

        User user = userRepo.findByUsername(authentication.getName());
        model.addAttribute("name",user.getName());
        return "secure/service";
    }

    @GetMapping(value = "/u")
    public String user(){
        return "user/u";
    }



}
