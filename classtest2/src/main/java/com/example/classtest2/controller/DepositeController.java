package com.example.classtest2.controller;

import com.example.classtest2.entity.Deposite;
import com.example.classtest2.repo.DepositeRepo;
import com.example.classtest2.repo.MemberRepo;
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
@RequestMapping(value = "/deposite/")
public class DepositeController {

    @Autowired
    private DepositeRepo depositeRepo;

    @Autowired
    private MemberRepo memberRepo;

    @GetMapping(value = "/deposite")
    public String depositeindex(Model model){
        model.addAttribute("depositelst",this.depositeRepo.findAll());
        return "deposite/listdeposite";
    }

    @GetMapping(value = "/depositeAdd")
    public String depositeAdd(Deposite deposite){
        return "deposite/Adddeposite";
    }

    @PostMapping(value = "/depositeAdd")
    public String depositeSave(@Valid Deposite deposite, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "deposite/Adddeposite";
        }else {

            this.depositeRepo.save(deposite);
            model.addAttribute("deposite", new Deposite());
            model.addAttribute("SuccMsg","Successfully Deposited");
        }
        return "deposite/Adddeposite";
    }


    @GetMapping(value = "/editd/{id}")
    private String editViewd(@PathVariable("id") Long id, Model model){
        model.addAttribute("deposite",this.depositeRepo.getOne(id));
        return "deposite/depositeEdit";
    }

    @PostMapping(value = "/editd/{id}")
    private String depositeEdit(@Valid Deposite deposite, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "deposite/depositeEdit";
        }

        this.depositeRepo.save(deposite);
        model.addAttribute("deposite", new Deposite());
        model.addAttribute("editMsg","Successfully Deleted");

        return "deposite/depositeEdit";
    }

    @PostMapping(value = "/deld/{id}")
    private String deleteDeposite(Model model, @PathVariable("id") Long id){
        if (id != null){
          this.depositeRepo.deleteById(id);
        }
        return "redirect:/deposite/deposite";
    }

}
