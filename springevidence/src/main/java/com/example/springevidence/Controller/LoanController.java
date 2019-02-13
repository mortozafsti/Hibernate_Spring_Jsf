package com.example.springevidence.Controller;

import com.example.springevidence.Entity.Loan;
import com.example.springevidence.Repo.LoanRepo;
import com.example.springevidence.Repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoanController {

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private MemberRepo memberRepo;

    @GetMapping(value = "/loan")
    public String loanindex(Model model){
        model.addAttribute("loanlist",this.loanRepo.findAll());
        return "loan";
    }

    @GetMapping(value = "/loanAdd")
    public String loanAdd(Loan loan){
        return "loanAdd";
    }

    @PostMapping(value = "/loanAdd")
    public String loanSave(@Valid Loan loan, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "loanAdd";
        }else {

            this.loanRepo.save(loan);
            model.addAttribute("loan", new Loan());
            model.addAttribute("SuccMsg","Successfully Given the Loan");
        }
        return "loanAdd";
    }


    @GetMapping(value = "/editl/{id}")
    private String editViewl(@PathVariable("id") Long id, Model model){
        model.addAttribute("loan",this.loanRepo.getOne(id));
        return "editloan";
    }

    @PostMapping(value = "/editl/{id}")
    private String loanEdit(@Valid Loan loan,BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "editloan";
        }

        this.loanRepo.save(loan);
        model.addAttribute("loan", new Loan());
        model.addAttribute("editMsg","Successfully Deleted");

        return "editloan";
    }

    @PostMapping(value = "/dell/{id}")
    private String deleteLoan(Model model, @PathVariable("id") Long id){
        if (id != null){
            this.loanRepo.deleteById(id);
        }
        return "redirect:/loan";
    }
}
