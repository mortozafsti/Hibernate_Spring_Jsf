package com.mortoza.ngosys.controller;

import com.mortoza.ngosys.entity.Ngo;
import com.mortoza.ngosys.entity.Role;
import com.mortoza.ngosys.repo.NgoRepo;
import com.mortoza.ngosys.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/user/")
public class NgoController {

    @Autowired
    private NgoRepo repo;

    @GetMapping(value = "add-ngo.jsf")
    public String displayNgo(Model model) {
        model.addAttribute("obj", new Ngo());
        return "add-ngo";
    }


    @PostMapping(value = "add-ngo.jsf")
    public String saveNgo(@Valid Ngo obj, BindingResult result, Model model) {
        if (obj != null) {
            //obj.setN_regi_date(new Date());
            repo.save(obj);
            model.addAttribute("successMesg", "success");
            model.addAttribute("obj", new Ngo());
        }

        return "add-ngo";
    }

    @GetMapping(value = "ngo-list.jsf")
    public String displayList(Model model) {
        model.addAttribute("list", repo.findAll());
        return "ngo-list";
    }
}
