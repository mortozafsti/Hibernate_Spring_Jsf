package com.example.classtest2.controller;

import com.example.classtest2.entity.Role;
import com.example.classtest2.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/addrole")
    public String addRole(){
        return "role/addrole";
    }
    @PostMapping(value = "/addrole")
    public String saveRole(@Valid Role role, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "role/addrole";
        }
        this.roleRepo.save(role);
        model.addAttribute("role", new Role());
        return "role/addrole";
    }

//    @GetMapping(value = "/role-save")
//    public String saveRole(){
//
//        Role role = new Role();
//        role.setRoleName("SUPERADMIN");
//        roleRepo.save(role);
//
//        Role role1 = new Role();
//        role1.setRoleName("ADMIN");
//        roleRepo.save(role1);
//
//        Role role2 = new Role();
//        role2.setRoleName("USER");
//        roleRepo.save(role2);
//
//       return "success";
//    }
}
