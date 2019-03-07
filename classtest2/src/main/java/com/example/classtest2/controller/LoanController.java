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
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

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
            model.addAttribute("loan", new Loan());
            model.addAttribute("SuccMsg","Successfully Given the Loan");

            LoanSummary summary;

            try {
                summary=loanSummaryRepo.findByLoanCode(loan.getLoanCode()) ;
                summary.setL_amount(summary.getL_amount() + loan.getL_amount());
                summary.setNo_collected_amount(summary.getNo_collected_amount() + loan.getL_payable_kisti());
                summary.setNo_total_amount(summary.getL_amount() + loan.getL_amount());
                this.loanSummaryRepo.save(summary);

            }catch (NullPointerException ne){
                LoanSummary loanSummary1=new LoanSummary();
                loanSummary1.setL_amount(loan.getL_amount());
                loanSummary1.setNo_collected_amount(0L);
                loanSummary1.setL_branch(loan.getL_brance());
                loanSummary1.setL_date(new Date());
                loanSummary1.setNo_due_Kisti(0L);
                loanSummary1.setNo_total_Kisti(loan.getL_kisti());
                loanSummary1.setMember(loan.getMember());
                loanSummary1.setLoanCode(loan.getLoanCode());
                loanSummary1.setNo_due_amount(loan.getL_amount());
                loanSummary1.setNo_total_amount(loan.getL_amount());

                this.loanSummaryRepo.save(loanSummary1);
                System.out.println("summary saved");
            }

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
