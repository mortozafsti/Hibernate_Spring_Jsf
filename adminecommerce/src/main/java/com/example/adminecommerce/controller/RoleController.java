package com.example.adminecommerce.controller;

import com.example.adminecommerce.entity.Role;
import com.example.adminecommerce.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    public RoleRepo roleRepo;

    @GetMapping(value = "/listrole")
    public String index(Model model){
        model.addAttribute("rolelist",this.roleRepo.findAll());
        return "role/rolelist";
    }

    @GetMapping(value = "/addrolee")
    public String addrole(Role role){
        return "role/addrole";
    }

    @PostMapping(value = "/addrolee")
    public String saveRole(@Valid Role role, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "role/addrole";
        }else{
            if (role != null){
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null){
                    model.addAttribute("exitMsg","RoleName is Allready Exist");
                }else{
                    this.roleRepo.save(role);
                    model.addAttribute("role",new Role());
                    model.addAttribute("syccessMsg","Data Successfully Saved");
                }
            }
        }
        return "role/addrole";
    }
}
