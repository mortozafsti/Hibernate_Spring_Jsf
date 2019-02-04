package com.mortoza.ngosys.controller;

import com.mortoza.ngosys.entity.Ngo;
import com.mortoza.ngosys.entity.Nominee;
import com.mortoza.ngosys.repo.NgoRepo;
import com.mortoza.ngosys.repo.NomineeRepo;
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
public class NomineeController {

    @Autowired
    private NomineeRepo repo;

    @GetMapping(value = "add-nominee.jsf")
    public String displayNgo(Model model) {
        model.addAttribute("obj", new Nominee());
        return "add-nominee";
    }


    @PostMapping(value = "add-nominee.jsf")
    public String saveNgo(@Valid Nominee obj, BindingResult result, Model model) {
        if (obj != null) {
            repo.save(obj);
            model.addAttribute("successMesg", "success");
            model.addAttribute("obj", new Nominee());
        }

        return "add-nominee";
    }

    @GetMapping(value = "nominee-list.jsf")
    public String displayList(Model model) {
        model.addAttribute("list", repo.findAll());
        return "nominee-list";
    }

}
