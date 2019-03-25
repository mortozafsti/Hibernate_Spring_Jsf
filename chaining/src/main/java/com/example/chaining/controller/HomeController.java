package com.example.chaining.controller;

import com.example.chaining.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CountryRepo countryRepo;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("countrylist",countryRepo.findAll());
        return "index";
    }

    @GetMapping(value = "/add")
    public String add(Model model){

        return "add";
    }
}
