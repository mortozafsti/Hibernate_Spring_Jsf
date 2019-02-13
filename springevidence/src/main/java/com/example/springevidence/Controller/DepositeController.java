package com.example.springevidence.Controller;

import com.example.springevidence.Entity.Deposite;
import com.example.springevidence.Repo.DepositeRepo;
import com.example.springevidence.Repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DepositeController {

    @Autowired
    private DepositeRepo depositeRepo;

    @Autowired
    private MemberRepo memberRepo;

    @GetMapping(value = "/deposite")
    public String depositeindex(Model model){
        model.addAttribute("depositelst",this.depositeRepo.findAll());
        return "deposite";
    }

    @GetMapping(value = "/depositeAdd")
    public String depositeAdd(Deposite deposite){
        return "depositeAdd";
    }

    @PostMapping(value = "/depositeAdd")
    public String depositeSave(@Valid Deposite deposite, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "depositeAdd";
        }else {

            this.depositeRepo.save(deposite);
            model.addAttribute("deposite", new Deposite());
            model.addAttribute("SuccMsg","Successfully Deposited");
        }
        return "depositeAdd";
    }


    @GetMapping(value = "/editd/{id}")
    private String editViewd(@PathVariable("id") Long id, Model model){
        model.addAttribute("deposite",this.depositeRepo.getOne(id));
        return "editDeposite";
    }

    @PostMapping(value = "/editd/{id}")
    private String depositeEdit(@Valid Deposite deposite,BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "editDeposite";
        }

        this.depositeRepo.save(deposite);
        model.addAttribute("deposite", new Deposite());
        model.addAttribute("editMsg","Successfully Deleted");

        return "editDeposite";
    }

    @PostMapping(value = "/deld/{id}")
    private String deleteDeposite(Model model, @PathVariable("id") Long id){
        if (id != null){
          this.depositeRepo.deleteById(id);
        }
        return "redirect:/deposite";
    }

}
