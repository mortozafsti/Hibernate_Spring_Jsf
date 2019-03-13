package com.example.classtest2.controller;

import com.example.classtest2.dto.CollectionDto;
import com.example.classtest2.entity.*;
import com.example.classtest2.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private CollectionRepo collectionRepo;

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private LoanSummaryRepo loanSummaryRepo;

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private DepositeRepo depositeRepo;

    @GetMapping(value =  "/")
    public String dasview(Model model) {
//        System.out.println(collectionRepo.findAll().size());
        double totalAmount = 0;
        double totalloanAmount = 0;
        double totalDueAmount = 0;
        double otherCollection = 0;
        double memberWiseDeposite = 0;
        for (Collection c : collectionRepo.findAll()) {
            totalAmount += c.getnOfColectedamount();
        }
        for (Loan l : loanRepo.findAll()) {
            totalloanAmount += l.getL_amount();
        }
        for (LoanSummary ds : loanSummaryRepo.findAll()) {
            totalDueAmount += ds.getNo_due_amount();
        }
        for (Member mr : memberRepo.findAll()) {
            otherCollection += mr.getM_admit_fee();
        }
        for (Deposite depo : depositeRepo.findAll()) {
            Deposite deposite = new Deposite();
            memberWiseDeposite = depo.getAmount();
        }
//        System.out.println(totalAmount);
        CollectionDto dto = new CollectionDto();
        dto.setTotalAmount(totalAmount);
        dto.setTotalloanAmount(totalloanAmount);
        dto.setTotalDueAmount(totalDueAmount);
        dto.setOtherCollection(otherCollection);
        dto.setMemberWiseDeposite(memberWiseDeposite);
        model.addAttribute("dto", dto);

        return "dashboard";
    }
}
