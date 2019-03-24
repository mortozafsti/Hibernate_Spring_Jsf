package com.example.classtest2.controller;

import com.example.classtest2.entity.Deposite;
import com.example.classtest2.entity.Loan;
import com.example.classtest2.entity.Member;
import com.example.classtest2.repo.DepositeRepo;
import com.example.classtest2.repo.LoanRepo;
import com.example.classtest2.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/deposite")
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
    public String depositeAdd(Deposite deposite,Model model){
        model.addAttribute("deposite", new Deposite());
        return "deposite/Adddeposite";
    }

//    private Loan loan = new Loan();
//    private Member member = new Member();
//    private Deposite collection = new Deposite();
//
//    @GetMapping(value = "/searchloan")
//    public String loanSearch(Model model, @RequestParam("lc") String loanCode) {
//        this.loan = this.loanRepo.findByLoanCode(loanCode);
////        this.member=this.memberRepo.findByM_name(loanCode);
//        collection = new Deposite();
//
////        collection.getMember().getM_name();
////        collection.setMemberName(loan.getMember().getM_name());
////        collection.setnOfTotalAmount(loan.getL_amount());
////        collection.setnOfTotalKisti(loan.getL_kisti());
////        collection.setnOfCollectedKisti(loanSummary.getNo_collected_Kisti()+1);
////        collection.setnOfColectedamount(collection.getnOfColectedamount());
////        collection.getMember();
//        model.addAttribute("collection", collection);
//        return "redirect:/collection/collectionAdd";
//    }
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
    private String editViewd( Model model,@PathVariable("id") Long id){
        model.addAttribute("deposite",this.depositeRepo.getOne(id));
        return "deposite/depositeedit";
    }

    @PostMapping(value = "/editd/{id}")
    private String depositeEdit(@Valid Deposite deposite, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "deposite/depositeedit";
        }

        this.depositeRepo.save(deposite);
        model.addAttribute("deposite", new Deposite());
        model.addAttribute("editMsg","Successfully Deleted");

        return "deposite/depositeedit";
    }

    @PostMapping(value = "/deld/{id}")
    private String deleteDeposite(Model model, @PathVariable("id") Long id){
        if (id != null){
          this.depositeRepo.deleteById(id);
        }
        return "redirect:/deposite/deposite";
    }

}
