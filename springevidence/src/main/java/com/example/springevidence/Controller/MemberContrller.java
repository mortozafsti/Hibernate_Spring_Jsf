package com.example.springevidence.Controller;

import com.example.springevidence.Entity.Member;
import com.example.springevidence.Repo.MemberRepo;
import com.example.springevidence.Repo.NgoRepo;
import com.example.springevidence.Repo.NomineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
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
        return "member";
    }

    @GetMapping(value = "/memberAdd")
    public String addmember(Member member){
        return "memberAdd";
    }

    @PostMapping(value = "/memberAdd")
    public String memberSave(@Valid Member member, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "memberAdd";
        }else {
            this.memberRepo.save(member);
            model.addAttribute("member", new Member());
        }
        return "memberAdd";
    }

    @GetMapping(value = "/memberedit/{id}")
    public String editViewrf(@PathVariable("id") Long id, Model model){
        model.addAttribute("member",this.memberRepo.getOne(id));
        return "memberEdit";
    }

    @PostMapping(value = "/memberedit/{id}")
    public String memberEdit(@Valid Member member, BindingResult bindingResult,Model model,@PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "memberEdit";
        } else {
                    this.memberRepo.save(member);
                    model.addAttribute("member", new Member());
                    model.addAttribute("syccessMsg","A Updated");
                }
        return "memberEdit";
    }
    @GetMapping(value = "/delm/{id}")
    public String deletemember(Model model, @PathVariable("id") Long id){
        if (id != null){
            this.memberRepo.deleteById(id);
        }
        return "redirect:/member";
    }
}
