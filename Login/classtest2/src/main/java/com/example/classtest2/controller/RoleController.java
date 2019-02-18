package com.example.classtest2.controller;

import com.example.classtest2.entity.Role;
import com.example.classtest2.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/role-save")
    public String saveRole(){
        Role role = new Role();

        role.setRoleName("SUPERADMIN");
        roleRepo.save(role);

        Role role1 = new Role();
        role1.setRoleName("ADMIN");
        roleRepo.save(role1);

        Role role2 = new Role();
        role2.setRoleName("USER");
        roleRepo.save(role2);

       return "success";
    }
}
