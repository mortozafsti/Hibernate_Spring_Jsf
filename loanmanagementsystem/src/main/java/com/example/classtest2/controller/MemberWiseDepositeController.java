package com.example.classtest2.controller;

import com.example.classtest2.entity.*;
import com.example.classtest2.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    private BranchRepo branchRepo;

    @Autowired
    private MemberWiseDepositeRepo memberWiseDepositeRepo;

    @GetMapping(value = "/memberwise")
    public String memberWiseD(MemberWiseDeposite  memberWiseDeposite,Model model){
        model.addAttribute("memberwisedepolist",this.memberWiseDepositeRepo.findAll());
        return "member/listmemberdepo";
    }

    @GetMapping(value = "/memberwisedepo")
    public String addmemberwise(MemberWiseDeposite memberWiseDeposite, Model model,@RequestParam(value = "lBrance",required = false) String lBrance){

        model.addAttribute("loanalist",this.loanRepo.findAll());
        model.addAttribute("loanalistBybranch",this.loanRepo.findAllByLBrance(lBrance));
        System.out.println("Size::::::: "+this.loanRepo.findAllByLBrance(lBrance).size());
        model.addAttribute("depositlistt",this.depositeRepo.findAll());
        model.addAttribute("memberlistt",this.memberRepo.findAll());
        model.addAttribute("nomineelistt",this.nomineeRepo.findAll());
        model.addAttribute("branchlistt",this.branchRepo.findAll());

        return "member/addmemberdepo";


    }
//    @GetMapping(value = "/memberwisedepo")
//    public List<Member> memberSingle(Model model,@RequestParam("id") String m_name){
//
//        System.out.println("ID: "+m_name);
//        List<Member> list = this.memberRepo.findAllByMember(new Member());
//
//        return list;
//
//    }

//    private Loan loan = new Loan();
//    private Member member = new Member();
//    private Deposite deposite = new Deposite();
//    private Nominee nominee = new Nominee();
//    private MemberWiseDeposite collection = new MemberWiseDeposite();
//
//    @GetMapping(value = "/searchloans")
//    public String loanSearchm(Model model, @RequestParam("lc") String loanCode) {
//        this.loan = this.loanRepo.findByLoanCode(loanCode);
//        this.deposite=this.depositeRepo.findByLoanCode(loanCode);
////        this.member=this.memberRepo.findByM_name(m_name);
//        this.nominee=this.nomineeRepo.findByLoanCode(loanCode);
//        collection = new MemberWiseDeposite();
//        collection.setL_Branch(loan.getL_brance());
////        collection.setM_Name(member.getM_name());
//        collection.setN_Name(nominee.getN_name());
//        collection.setD_Amount(deposite.getAmount());
////        collection.setnOfCollectedKisti(loanSummary.getNo_collected_Kisti()+1);
////        collection.setnOfColectedamount(collection.getnOfColectedamount());
//        collection.setLoan(loan);
//        model.addAttribute("collection", collection);
//        return "redirect:/member/memberwisedepo";
//    }

    @PostMapping(value = "/memberwisedepo")
    public String memberwiseSave(@Valid MemberWiseDeposite memberWiseDeposite, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "member/addmemberdepo";
        }else {

            //memberWiseDeposite.setLoan(memberWiseDeposite.getLoan());
           this.memberWiseDepositeRepo.save(memberWiseDeposite);
            model.addAttribute("loanalist",this.loanRepo.findAll());

            model.addAttribute("depositlistt",this.depositeRepo.findAll());
            model.addAttribute("memberlistt",this.memberRepo.findAll());
            model.addAttribute("nomineelistt",this.nomineeRepo.findAll());

            model.addAttribute("memberWiseDeposite", new MemberWiseDeposite());
            model.addAttribute("SuccMsg","Deposit Successfully Saved");
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
