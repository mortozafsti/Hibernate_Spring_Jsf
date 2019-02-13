package com.example.springevidence.Controller;

import com.example.springevidence.Entity.Ngo;
import com.example.springevidence.Entity.Nominee;
import com.example.springevidence.Repo.NomineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NomineeController {

    @Autowired
    private NomineeRepo nomineeRepo;

    @GetMapping(value = "/nominee")
    public String indexNominee(Model model){
        model.addAttribute("nomineelist",this.nomineeRepo.findAll());
        return "nominee";
    }

    @GetMapping(value = "/nomineeAdd")
    public String addn(Nominee nominee){
        return "nomineeAdd";
    }
    @PostMapping(value = "/nomineeAdd")
    public String save(@Valid Nominee nominee, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "nomineeAdd";
        }
        this.nomineeRepo.save(nominee);
        model.addAttribute("nominee", new Nominee());
        model.addAttribute("nomineeMsg","Successfully Added Nominee");
        return "nomineeAdd";

    }
}
