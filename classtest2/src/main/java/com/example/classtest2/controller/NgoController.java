package com.example.classtest2.controller;

import com.example.classtest2.entity.Ngo;
import com.example.classtest2.repo.NgoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/ngo/")
public class NgoController {

    @Autowired
    private NgoRepo ngoRepo;

    @GetMapping(value = "/listngo")
    public String ngoindex(Model model){
        model.addAttribute("ngolist",this.ngoRepo.findAll());
        return "ngo/listngo";
    }

    @GetMapping(value = "/addngo")
    public String add(Ngo ngo){
        return "ngo/addngo";
    }

    @PostMapping(value = "/addngo")
    public String save(@Valid Ngo ngo, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "ngo/addngo";
        }
        this.ngoRepo.save(ngo);
        model.addAttribute("ngo", new Ngo());
        model.addAttribute("ngoMsg","Successfully Added Ngo");
        return "ngo/addngo";
    }

    @GetMapping(value = "/ngoedit/{id}")
    public String editViewr(@PathVariable("id") Long id, Model model){
        model.addAttribute("ngo",this.ngoRepo.getOne(id));
        return "ngo/ngoedit";
    }

    @PostMapping(value = "/ngoedit/{id}")
    public String roleEdit(@Valid Ngo ngo, BindingResult bindingResult,Model model,@PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "ngo/ngoedit";
        }else {
                    this.ngoRepo.save(ngo);
                    model.addAttribute("ngo", new Ngo());
                    model.addAttribute("syccessMsg","A Updated");
                }

        return "ngo/ngoedit";
    }
    @GetMapping(value = "/deln/{id}")
    public String deleterole(Model model, @PathVariable("id") Long id){
        if (id != null){
            this.ngoRepo.deleteById(id);
        }
        return "redirect:/ngo/listngo";
    }
}
