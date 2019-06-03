package com.example.adminecommerce.controller;

import com.example.adminecommerce.entity.User;
import com.example.adminecommerce.repo.RoleRepo;
import com.example.adminecommerce.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/listuser")
    public String index(Model model){
        model.addAttribute("userlist",this.userRepo.findAll());
        return "user/listuser";
    }

    @GetMapping(value = "/addusers")
    public String addUser(User user, Model model){
        model.addAttribute("addlisthome",this.roleRepo.findAll());
        return "user/adduser";
    }

    @PostMapping(value = "/addusers")
    public String saveUser(@Valid User user, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("addlisthome",this.roleRepo.findAll());
            return "user/adduser";
        }
        if (user != null){
            User user1 = this.userRepo.findByUserName(user.getUserName());
            if (user1 != null){
                model.addAttribute("exitMsg","UserName is Already Exist");
            }else {
                this.userRepo.save(user);
                model.addAttribute("user", new User());
                model.addAttribute("addlisthome",this.roleRepo.findAll());
                model.addAttribute("succ","UserName Successfully Save");

            }
        }
        return "user/adduser";
    }
}
