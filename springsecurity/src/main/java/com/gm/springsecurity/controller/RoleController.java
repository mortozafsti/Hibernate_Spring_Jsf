package com.gm.springsecurity.controller;

import com.gm.springsecurity.entity.Role;
import com.gm.springsecurity.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/role-save")
    public String saveRole(){
        Role role=new Role();
        role.setRolename("SUPERADMIN");
        roleRepo.save(role);

        Role role2=new Role();
        role2.setRolename("ADMIN");
        roleRepo.save(role2);

        Role role3=new Role();
        role3.setRolename("USER");
        roleRepo.save(role3);

        return "success";
    }
}
