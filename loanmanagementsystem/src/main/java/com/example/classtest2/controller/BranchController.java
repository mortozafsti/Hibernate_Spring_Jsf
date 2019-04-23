package com.example.classtest2.controller;

import com.example.classtest2.entity.Branch;
import com.example.classtest2.repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/deposite")
public class BranchController {

    @Autowired
    private BranchRepo branchRepo;

    @GetMapping(value = "/branchlist")
    public String index(Model model){
        model.addAttribute("branchlist",this.branchRepo.findAll());
        return "deposite/listbranch";
    }

    @GetMapping(value = "/branchAdd")
    public String Addbranch(Branch branch){
        return "deposite/addbranch";
    }

    @PostMapping(value = "/branchAdd")
    public String saveBranch(@Valid Branch branch, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "deposite/addbranch";
        }else

            this.branchRepo.save(branch);
            model.addAttribute("branch", new Branch());
            model.addAttribute("BranMsg","Successfully Saved Branch");



        return "deposite/addbranch";
    }


}
