package com.example.classtest2.controller;

import com.example.classtest2.dto.CollectionDto;
import com.example.classtest2.entity.Collection;
import com.example.classtest2.entity.Loan;
import com.example.classtest2.repo.CollectionRepo;
import com.example.classtest2.repo.LoanRepo;
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

    @GetMapping(value = {"/dashboard","/"})
    public String dasview(Model model){
//        System.out.println(collectionRepo.findAll().size());
       double totalAmount = 0;
        double totalloanAmount = 0;
                for(Collection c : collectionRepo.findAll()){
                    totalAmount += c.getnOfColectedamount();
                }
        for(Loan l : loanRepo.findAll()){
            totalloanAmount += l.getL_amount();
        }
//        System.out.println(totalAmount);
        CollectionDto dto=new CollectionDto();
        dto.setTotalAmount(totalAmount);
        dto.setTotalloanAmount(totalloanAmount);

        model.addAttribute("dto",dto);

        return "dashboard";
    }
}
