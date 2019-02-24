package com.example.classtest2.controller;

import com.example.classtest2.entity.Role;
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
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    @GetMapping(value = "/index")
    public String displayHomr(Role role) {
        return "index";
    }

    @GetMapping(value = "/addrole")
    public String addRole(Role role){
        return "role/addrole";
    }
    @GetMapping(value = "/rolelist")
    public String addRolelist(Model model){
        return "role/listrole";
    }

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
