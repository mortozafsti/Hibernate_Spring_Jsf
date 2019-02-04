package com.mortoza.ngosys.controller;

import com.mortoza.ngosys.entity.Member;
import com.mortoza.ngosys.entity.Nominee;
import com.mortoza.ngosys.repo.MemberRepo;
import com.mortoza.ngosys.repo.NomineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user/")
public class MemberController {

    @Autowired
    private MemberRepo repo;

    @GetMapping(value = "add-member.jsf")
    public String displayMember(Model model) {
        model.addAttribute("obj", new Member());
        return "add-member";
    }


    @PostMapping(value = "add-member.jsf")
    public String saveMember(@Valid Member obj, BindingResult result, Model model) {
        if (obj != null) {
            repo.save(obj);
            model.addAttribute("successMesg", "success");
            model.addAttribute("obj", new Member());
        }

        return "add-member";
    }

    @GetMapping(value = "member-list.jsf")
    public String displayList(Model model) {
        model.addAttribute("list", repo.findAll());
        return "member-list";
    }

}
