package com.example.springevidence.Controller;

import com.example.springevidence.Entity.Ngo;
import com.example.springevidence.Repo.NgoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NgoController {

    @Autowired
    private NgoRepo ngoRepo;

    @GetMapping(value = "/ngo")
    public String ngoindex(Model model){
        model.addAttribute("ngolist", this.ngoRepo.findAll());
        return "ngo";
    }

    @GetMapping(value = "/ngoAdd")
    public String add(Ngo ngo){
        return "ngoAdd";
    }

    @PostMapping(value = "/ngoAdd")
    public String save(@Valid Ngo ngo, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "ngoAdd";
        }
        this.ngoRepo.save(ngo);
        model.addAttribute("ngo", new Ngo());
        model.addAttribute("ngoMsg","Successfully Added Ngo");
        return "ngoAdd";
    }

}
