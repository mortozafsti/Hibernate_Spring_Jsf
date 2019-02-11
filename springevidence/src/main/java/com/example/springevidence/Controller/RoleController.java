package com.example.springevidence.Controller;

import com.example.springevidence.Entity.Role;
import com.example.springevidence.Repo.Rolerepo;
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
    public String roleIndex(Model model){
        model.addAttribute("rolelist",this.rolerepo.findAll());
        return "role";
    }

    @GetMapping(value = "/roleAdd")
    public String add(Role role){
        return "roleAdd";
    }

    @PostMapping(value = "/roleAdd")
    public String roleSave(@Valid Role role, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "roleAdd";
        }
            this.rolerepo.save(role);
            model.addAttribute("role", new Role());

        return "roleAdd";
    }

}
