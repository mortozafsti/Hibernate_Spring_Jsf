package com.mortoza.ngosys.controller;

import com.mortoza.ngosys.entity.Role;
import com.mortoza.ngosys.entity.User;
import com.mortoza.ngosys.repo.RoleRepo;
import com.mortoza.ngosys.repo.UserRepo;
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
public class UserController {

    @Autowired
    private UserRepo repo;

    @GetMapping(value = "add-user.jsf")
    public String displayRole(Model model){
        model.addAttribute("obj",new User());
        return "add-user";
    }


    @PostMapping(value = "add-user.jsf")
    public String saveRole(@Valid User obj, BindingResult result, Model model){
        if (obj != null){
            repo.save(obj);
            model.addAttribute("successMesg","success");
            model.addAttribute("obj", new User());
        }

        return "add-user";
    }

    @GetMapping(value = "user-list.jsf")
    public String displayList(Model model){
        model.addAttribute("list",repo.findAll());
        return "user-list";
    }

}
