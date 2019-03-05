package com.example.classtest2.controller;

import com.example.classtest2.entity.Loan;
import com.example.classtest2.entity.LoanSummary;
import com.example.classtest2.repo.LoanRepo;
import com.example.classtest2.repo.LoanSummaryRepo;
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
import java.util.Optional;

@Controller
@RequestMapping(value = "/loan/")
public class LoanController {

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private LoanSummaryRepo loanSummaryRepo;


    @Autowired
    private MemberRepo memberRepo;

    @GetMapping(value = "/loanlists")
    public String loanindex(Model model){
        model.addAttribute("loanlist",this.loanRepo.findAll());
        return "loan/listloan";
    }

    @GetMapping(value = "/loanAdd")
    public String loanAdd(Loan loan){
        return "loan/Addloan";
    }

    @PostMapping(value = "/loanAdd")
    public String loanSave(@Valid Loan loan, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "loan/Addloan";
        }else {

            this.loanRepo.save(loan);

            Optional<LoanSummary> summary=loanSummaryRepo.findByMember(loan.getMember()) ;
            LoanSummary loanSummary=new LoanSummary();
            loanSummary.setL_branch(loan.getL_brance());
            loanSummary.setL_amount(loan.getL_amount());
            loanSummary.setL_date(loan.getL_date());
            if(summary == null ){
                this.loanSummaryRepo.save(loanSummary);
            }else{
                loanSummary.setId(summary.get().getId());
                loanSummary.setL_amount(summary.get().getL_amount() + loan.getL_amount());
//                loanSummary.setNo_collected_amount(summary.get().getNo_collected_amount() + loan.getL_payable_kisti());
                this.loanSummaryRepo.save(loanSummary);
            }


            model.addAttribute("loan", new Loan());
            model.addAttribute("SuccMsg","Successfully Given the Loan");
        }
        return "loan/Addloan";
    }


    @GetMapping(value = "/editloan/{id}")
    private String editViewl(@PathVariable("id") Long id, Model model){
        model.addAttribute("loan",this.loanRepo.getOne(id));
        return "loan/loanedit";
    }

    @PostMapping(value = "/editloan/{id}")
    private String loanEdit(@Valid Loan loan, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "loan/loanedit";
        }
        this.loanRepo.save(loan);
        model.addAttribute("loan", new Loan());
        model.addAttribute("SuccMsg","SuccessFully Updated");

        return "loan/loanedit";
    }

    @PostMapping(value = "/dell/{id}")
    private String deleteLoan(Model model, @PathVariable("id") Long id){
        if (id != null){
            this.loanRepo.deleteById(id);
        }
        return "redirect:/loan/loanlists";
    }
}
