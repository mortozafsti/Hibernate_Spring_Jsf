package com.example.classtest2.controller;

import com.example.classtest2.entity.Collection;
import com.example.classtest2.entity.Deposite;
import com.example.classtest2.entity.Loan;
import com.example.classtest2.entity.LoanSummary;
import com.example.classtest2.repo.CollectionRepo;
import com.example.classtest2.repo.LoanRepo;
import com.example.classtest2.repo.LoanSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/collection/")
public class CollectionController {

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private LoanSummaryRepo loanSummaryRepo;

    @Autowired
    private CollectionRepo collectionRepo;

    @GetMapping(value = "/collection")
    public String depositeindex(Model model) {
        model.addAttribute("collectionlist", this.collectionRepo.findAll());
        return "collect/listcollection";
    }

    private Loan loan;
    private LoanSummary loanSummary;
    private Collection collection;

    @GetMapping(value = "/collectionAdd")
    public String depositeAdd(Model model) {
        model.addAttribute("loancodelist", this.loanRepo.findAll());
        model.addAttribute("collection", collection);
        return "collect/addcollection";
    }

    @GetMapping(value = "/searchloan")
    public String loanSearch(Model model, @RequestParam("lc") String loanCode) {
        this.loan = this.loanRepo.findByLoanCode(loanCode);
        this.loanSummary=this.loanSummaryRepo.findByLoanCode(loanCode);
        collection = new Collection();
        collection.setLoanCode(loan.getLoanCode());
        collection.setLoanCode(loan.getLoanCode());
        collection.setMemberName(loan.getMember().getM_name());
        collection.setnOfTotalAmount(loan.getL_amount());
        collection.setnOfTotalKisti(loan.getL_kisti());
        collection.setnOfCollectedKisti(loanSummary.getNo_collected_Kisti()+1);
        collection.setnOfColectedamount(collection.getnOfColectedamount());
        collection.setLoan(loan);
        model.addAttribute("collection", collection);
        return "redirect:/collection/collectionAdd";
    }

    @PostMapping(value = "/collectionAdd")
    public String depositeSave(@Valid Collection collection, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loancodelist", this.loanRepo.findAll());
            return "collect/addcollection";
        } else {

            this.collectionRepo.save(collection);
//            model.addAttribute("collection", new Collection());
            model.addAttribute("SuccMsg", "Successfully Collected");



            try {
                loanSummary=loanSummaryRepo.findByLoanCode(loan.getLoanCode());
                loanSummary.setNo_due_Kisti(loanSummary.getNo_total_Kisti() - collection.getnOfCollectedKisti());
                loanSummary.setNo_due_amount(loanSummary.getNo_due_amount() - collection.getnOfColectedamount());
                loanSummary.setNo_collected_amount(loanSummary.getNo_collected_amount()+collection.getnOfColectedamount());
                loanSummary.setNo_collected_Kisti(collection.getnOfCollectedKisti());
                this.loanSummaryRepo.save(loanSummary);

            }catch (NullPointerException e){
//                LoanSummary loanSummary1 = new LoanSummary();
//                loanSummary1.getNo_due_Kisti();
//                loanSummary1.getNo_collected_amount();
//                loanSummary1.setNo_collected_Kisti(collection.getnOfCollectedKisti());
//                loanSummary1.setNo_collected_amount(loanSummary1.getNo_collected_amount()+collection.getnOfColectedamount());
//                loanSummary1.setNo_due_amount(loanSummary1.getNo_total_amount() - loanSummary1.getNo_collected_amount());
//                this.loanSummaryRepo.save(loanSummary1);
//
//                System.out.println("LoanSummary Saved");
            }

        }
        model.addAttribute("loancodelist", this.loanRepo.findAll());
        return "collect/addcollection";
    }

    @GetMapping(value = "/editcollection/{id}")
    private String editViewd(Model model, @PathVariable("id") Long id) {
        model.addAttribute("collection", this.collectionRepo.getOne(id));
        return "collect/editcollection";
    }

    @PostMapping(value = "/editcollection/{id}")
    private String collectionEdit(@Valid Collection collection, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "collect/editcollection";
        }

        this.collectionRepo.save(collection);
        model.addAttribute("collection", new Deposite());
        model.addAttribute("editMsg", "Successfully Deleted");

        return "collect/editcollection";
    }

    @PostMapping(value = "/delcollection/{id}")
    private String deleteCollect(Model model, @PathVariable("id") Long id) {
        if (id != null) {
            this.collectionRepo.deleteById(id);
        }
        return "redirect:/collection/collection";
    }

    ///Search Option
}
