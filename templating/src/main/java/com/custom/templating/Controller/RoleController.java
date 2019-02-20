package com.custom.templating.Controller;

import com.custom.templating.Entity.Role;
import com.custom.templating.repo.RoleRepo;
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
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/add-role")
    public String addRole(Role role,Model model){
        return "add-role";
    }

    @PostMapping(value = "/add-role")
    public String roleSave(@Valid Role role, BindingResult result,Model model){
        if (role != null){
            this.roleRepo.save(role);
            model.addAttribute("role", new Role());
        }

        return "add-role";

    }

}
