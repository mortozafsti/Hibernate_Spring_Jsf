package com.mortoza.ngosys.controller;

import com.mortoza.ngosys.entity.Role;
import com.mortoza.ngosys.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user/")
public class RoleController {

    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "add-role.jsf")
    public String displayRole(Model model) {
        model.addAttribute("obj", new Role());
        return "add-role";
    }


//    @PostMapping(value = "add-role.jsf")
//    public String saveRole(@Valid Role obj, BindingResult result, Model model) {
//        if (obj != null) {
//            repo.save(obj);
//            model.addAttribute("successMesg", "success");
//            model.addAttribute("obj", new Role());
//        }
//
//        return "add-role";
//    }
//
//    @GetMapping(value = "role-list.jsf")
//    public String displayList(Model model) {
//        model.addAttribute("list", repo.findAll());
//        return "role-list";
//    }

}
