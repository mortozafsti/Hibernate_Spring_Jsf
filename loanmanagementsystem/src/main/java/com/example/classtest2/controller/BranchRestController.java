package com.example.classtest2.controller;

import com.example.classtest2.entity.Branch;
import com.example.classtest2.entity.Deposite;
import com.example.classtest2.entity.Member;
import com.example.classtest2.repo.BranchRepo;
import com.example.classtest2.repo.DepositeRepo;
import com.example.classtest2.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BranchRestController {

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private DepositeRepo depositeRepo;

    @GetMapping(value = "/memberbybranch")
    public List<Member> addmemberwiseds(@RequestParam("id") Long id){
        System.out.println("call.....======.....");
        List<Member> memberlistBybranch= new ArrayList<>();
        if(id != null ) {
            memberlistBybranch = this.memberRepo.findAllByBranch(new Branch(id));
            System.out.println("called");
        }
        return memberlistBybranch;

    }

    @GetMapping(value = "/nomineeByMember")
    public List<Member> nomineesByMember(@RequestParam("id") Long id){
        System.out.println("call.....======.....");
        List<Member> memberlistBybranch= new ArrayList<>();
        if(id != null ) {
            memberlistBybranch = this.memberRepo.findAllById(id);
            System.out.println("called");
        }
        return memberlistBybranch;

    }

    @GetMapping(value = "/depositeByMember")
    public List<Deposite> depositeByMembers(@RequestParam("id") Long id){
        System.out.println("call.....******======.....");
        List<Deposite> mdepositlistBybranch= new ArrayList<>();
        if(id != null ) {
            mdepositlistBybranch = this.depositeRepo.findAllByMember(new Member(id));
            System.out.println("called");
        }
        return mdepositlistBybranch;

    }

}
