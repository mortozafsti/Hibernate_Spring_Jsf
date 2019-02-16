package com.example.classtest.controller;

import com.example.classtest.entity.User;
import com.example.classtest.repo.Rolerepo;
import com.example.classtest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Rolerepo rolerepo;

    @GetMapping(value = "/")
    public String userindex(Model model){
        model.addAttribute("userlist",this.userRepo.findAll());
        return "index";
    }

    @GetMapping(value = "/userr")
    public String userAdd(User user, Model model){
        model.addAttribute("rolelistHome", this.rolerepo.findAll());
        return "userAdd";
    }

    @PostMapping(value = "/userr")
    public String UserSave(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "userAdd";
        }
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("Msg","Successfully Added");

        return "userAdd";

    }
}
