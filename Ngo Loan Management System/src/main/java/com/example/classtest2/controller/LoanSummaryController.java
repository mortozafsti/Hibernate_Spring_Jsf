package com.example.classtest2.controller;

import com.example.classtest2.repo.LoanSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.modelmbean.ModelMBeanAttributeInfo;

@Controller
public class LoanSummaryController {

    @Autowired
    private LoanSummaryRepo loanSummaryRepo;

    @GetMapping(value = "/loansummarylist")
    public String summarylist(Model model){
        model.addAttribute("summarylist",this.loanSummaryRepo.findAll());
        return "loan/loanSummarylist";
    }
}
