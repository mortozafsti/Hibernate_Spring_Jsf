package com.example.classtest2.controller;

import com.example.classtest2.entity.Ngo;
import com.example.classtest2.entity.Nominee;
import com.example.classtest2.repo.NomineeRepo;
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
@RequestMapping(value = "/nominee/")
public class NomineeController {

    @Autowired
    private NomineeRepo nomineeRepo;

    @GetMapping(value = "/nomineelists")
    public String indexNominee(Model model){
        model.addAttribute("nomineelist",this.nomineeRepo.findAll());
        return "nominee/listnominee";
    }

    @GetMapping(value = "/addnominee")
    public String addn(Nominee nominee){
        return "nominee/addnominee";
    }

    @PostMapping(value = "/addnominee")
    public String save(@Valid Nominee nominee, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "nominee/addnominee";
        }
        this.nomineeRepo.save(nominee);
        model.addAttribute("nominee", new Nominee());
        model.addAttribute("nomineeMsg","Successfully Added Nominee");
        return "nominee/addnominee";

    }

    @GetMapping(value = "/nomineedit/{id}")
    public String editViewr(@PathVariable("id") Long id, Model model){
        model.addAttribute("ngo",this.nomineeRepo.getOne(id));
        return "nominee/nomineeedit";
    }

    @PostMapping(value = "/nomineedit/{id}")
    public String roleEdit(@Valid Nominee nominee, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "nominee/nomineeedit";
        }else {
            this.nomineeRepo.save(nominee);
            model.addAttribute("nominee", new Nominee());
            model.addAttribute("syccessMsg","A Updated");
        }

        return "nominee/nomineeedit";
    }
    @GetMapping(value = "/delnominee/{id}")
    public String deleterole(Model model, @PathVariable("id") Long id){
        if (id != null){
            this.nomineeRepo.deleteById(id);
        }
        return "redirect:/nominee/listnominee";
    }
}
