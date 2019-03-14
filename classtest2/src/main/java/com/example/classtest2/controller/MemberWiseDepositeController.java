package com.example.classtest2.controller;

import com.example.classtest2.entity.Member;
import com.example.classtest2.entity.MemberWiseDeposite;
import com.example.classtest2.repo.*;
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
@RequestMapping(value = "/member/")
public class MemberWiseDepositeController {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private DepositeRepo depositeRepo;

    @Autowired
    private NomineeRepo nomineeRepo;

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private MemberWiseDepositeRepo memberWiseDepositeRepo;

    @GetMapping(value = "/memberwise")
    public String memberWiseD(MemberWiseDeposite  memberWiseDeposite,Model model){
        model.addAttribute("memberwisedepolist",this.memberWiseDepositeRepo.findAll());
        return "member/list";
    }

    @GetMapping(value = "/memberwisedepo")
    public String addmemberwise(MemberWiseDeposite memberWiseDeposite, Model model){

        model.addAttribute("loanalist",this.loanRepo.findAll());
        model.addAttribute("depositlistt",this.depositeRepo.findAll());
        model.addAttribute("memberlistt",this.memberRepo.findAll());
        model.addAttribute("nomineelistt",this.nomineeRepo.findAll());

        return "member/addmemberdepo";
    }

    @PostMapping(value = "/memberwisedepo")
    public String memberwiseSave(@Valid MemberWiseDeposite memberWiseDeposite, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "member/addmemberdepo";
        }else {

            memberWiseDeposite.setLoan(memberWiseDeposite.getLoan());
            this.memberWiseDepositeRepo.save(memberWiseDeposite);

            model.addAttribute("loanalist",this.loanRepo.findAll());
            model.addAttribute("depositlistt",this.depositeRepo.findAll());
            model.addAttribute("memberlistt",this.memberRepo.findAll());
            model.addAttribute("nomineelistt",this.nomineeRepo.findAll());

            model.addAttribute("memberWiseDeposite", new MemberWiseDeposite());
        }
        return "member/addmemberdepo";
    }

    @GetMapping(value = "/membereditdepo/{id}")
    public String editViewrfwise(@PathVariable("id") Long id, Model model){
        model.addAttribute("memberwisedepos",this.memberWiseDepositeRepo.getOne(id));

        model.addAttribute("loanalist",this.loanRepo.findAll());
        model.addAttribute("depositlistt",this.depositeRepo.findAll());
        model.addAttribute("memberlistt",this.memberRepo.findAll());
        model.addAttribute("nomineelistt",this.nomineeRepo.findAll());
        return "member/membereditt";
    }

    @PostMapping(value = "/membereditdepo/{id}")
    public String memberwiseEdit(@Valid MemberWiseDeposite memberWiseDeposite, BindingResult bindingResult, Model model, @PathVariable("id") Long id){

        if (bindingResult.hasErrors()){
            model.addAttribute("loanalist",this.loanRepo.findAll());
            model.addAttribute("depositlistt",this.depositeRepo.findAll());
            model.addAttribute("memberlistt",this.memberRepo.findAll());
            model.addAttribute("nomineelistt",this.nomineeRepo.findAll());
            return "member/membereditt";
        } else {
            System.out.println(memberWiseDeposite);
                    this.memberWiseDepositeRepo.save(memberWiseDeposite);
                    model.addAttribute("memberwise", new MemberWiseDeposite());
                    model.addAttribute("syccessMsg","A Updated");
                }
        model.addAttribute("loanalist",this.loanRepo.findAll());
        model.addAttribute("depositlistt",this.depositeRepo.findAll());
        model.addAttribute("memberlistt",this.memberRepo.findAll());
        model.addAttribute("nomineelistt",this.nomineeRepo.findAll());
        return "member/membereditt";
    }

    @GetMapping(value = "/delmwise/{id}")
    public String deletemember(Model model, @PathVariable("id") Long id){
        if (id != null){
            this.memberWiseDepositeRepo.deleteById(id);
        }
        return "redirect:/member/memberwise";
    }
}
