package com.example.classtest2.controller;

import com.example.classtest2.entity.Member;
import com.example.classtest2.repo.MemberRepo;
import com.example.classtest2.repo.NgoRepo;
import com.example.classtest2.repo.NomineeRepo;
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
public class MemberContrller {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private NgoRepo ngoRepo;


    
    @Autowired
    private NomineeRepo nomineeRepo;

    @GetMapping(value = "/member")
    public String memberIndex(Model model){
        model.addAttribute("memberlist",this.memberRepo.findAll());
        return "member/listmember";
    }

    @GetMapping(value = "/memberAdd")
    public String addmember(Member member){
        return "member/addmember";
    }

    @PostMapping(value = "/memberAdd")
    public String memberSave(@Valid Member member, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "member/addmember";
        }else {
            this.memberRepo.save(member);
            model.addAttribute("member", new Member());
        }
        return "member/addmember";
    }

    @GetMapping(value = "/memberedit/{id}")
    public String editViewrf(@PathVariable("id") Long id, Model model){
        model.addAttribute("member",this.memberRepo.getOne(id));
        return "member/memberedit";
    }

    @PostMapping(value = "/memberedit/{id}")
    public String memberEdit(@Valid Member member, BindingResult bindingResult, Model model, @PathVariable("id") Long id){

        if (bindingResult.hasErrors()){
            return "member/memberedit";
        } else {
            System.out.println(member
            );
                    this.memberRepo.save(member);
                    model.addAttribute("member", new Member());
                    model.addAttribute("syccessMsg","A Updated");
                }
        return "member/memberedit";
    }

    @GetMapping(value = "/delm/{id}")
    public String deletemember(Model model, @PathVariable("id") Long id){
        if (id != null){
            this.memberRepo.deleteById(id);
        }
        return "redirect:/member/member";
    }
}
