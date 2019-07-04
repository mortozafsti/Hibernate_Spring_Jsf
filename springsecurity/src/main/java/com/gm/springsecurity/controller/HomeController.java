package com.gm.springsecurity.controller;

import com.gm.springsecurity.entity.User;
import com.gm.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    UserRepo userRepo;

    @GetMapping(value = "/home")
    public String secureView(Model model) {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name",auth.getName());
        User user = userRepo.findByName(auth.getName());
        model.addAttribute("name",user.getName());

        return "admin/home";
    }
}
