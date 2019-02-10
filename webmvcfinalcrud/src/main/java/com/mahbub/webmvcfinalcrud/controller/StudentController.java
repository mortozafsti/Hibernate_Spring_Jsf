package com.mahbub.webmvcfinalcrud.controller;

import com.mahbub.webmvcfinalcrud.entity.Student;
import com.mahbub.webmvcfinalcrud.repo.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private Studentrepo studentrepo;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("lists",this.studentrepo.findAll());
        return "index";
    }
    @GetMapping(value = "/add")
    public String add(Student student){
        return "add";
    }
    @PostMapping(value = "/add")
    public String doSave(@Valid Student student, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "add";
        }
        this.studentrepo.save(student);
        model.addAttribute("student",new Student());
        return "redirect:/";
    }
    @GetMapping(value = "/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id){
        model.addAttribute("student", this.studentrepo.getOne(id));
        return "edit";
    }
    @PostMapping(value = "/edit/{id}")
    public String doEdit(@Valid Student student, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "edit";
        }
        this.studentrepo.save(student);
        model.addAttribute("student",new Student());
        return "redirect:/";
    }
}
