package com.example.classtest3.controller;

import com.example.classtest3.entity.Role;
import com.example.classtest3.entity.User;
import com.example.classtest3.repo.RoleRepo;
import com.example.classtest3.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    @Autowired
    PasswordEncoder passwordEncoder;

//    @GetMapping(value = "/user-save")
//    public String saveUser(){
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1l));
//        User user = new User("Mortoza", "sadmin", passwordEncoder.encode("1234"), "mortoza@gmail.com", true, roles);
//        userRepo.save(user);
//
//        Set<Role> roles1 = new HashSet<>();
//        roles1.add(new Role(2l));
//        User user1 = new User("Milton", "admin", passwordEncoder.encode("12345"), "milton@gmail.com", true, roles1);
//        userRepo.save(user1);
//
//        Set<Role> roles2 = new HashSet<>();
//        roles2.add(new Role(3l));
//        User user2 = new User("Rakib", "user", passwordEncoder.encode("123456"), "rakib@gmail.com", true, roles2);
//        userRepo.save(user2);
//
//        return "success";
//    }

    @GetMapping(value = "/add")
    public String indexs(User user,Model model){
        model.addAttribute("rolelists",this.roleRepo.findAll());
        return "role";
    }

    @PostMapping(value = "/u")
    public String save(@Valid User user, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "user/u";
        }
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("sucMsg","Successfully Saved");

        return "u";
    }
}
