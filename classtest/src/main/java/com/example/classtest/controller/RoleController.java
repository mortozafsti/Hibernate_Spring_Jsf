package com.example.classtest.controller;

import com.example.classtest.entity.Role;
import com.example.classtest.repo.Rolerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoleController {

    @Autowired
    private Rolerepo rolerepo;

    @GetMapping(value = "/role")
    public String roleindex(Model model){
        model.addAttribute("rolelist",this.rolerepo.findAll());
        return "role";
    }

    @GetMapping(value = "/roleAdd")
    public String addRole(Role role){
        return "roleAdd";
    }

    @PostMapping(value = "/roleAdd")
    public String roleSave(@Valid Role role, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "roleAdd";
        }else {
            if (role != null){
                Role role1 = this.rolerepo.findByRoleName(role.getRoleName());

                if (role1 != null){
                    model.addAttribute("exitMsg","RoleName is Already Exist");
                }else {
                    this.rolerepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("successMsg","Successfully Save");
                }
            }
        }
        return "roleAdd";
    }
}
