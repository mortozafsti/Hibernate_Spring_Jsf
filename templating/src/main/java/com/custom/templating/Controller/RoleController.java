package com.custom.templating.Controller;

import com.custom.templating.Entity.Role;
import com.custom.templating.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "add-rolee")
    public String addRole(Model model){
        model.addAttribute("obj", new Role());
        return "add-role";
    }
}
