package com.example.springevidence.Controller;

import com.example.springevidence.Entity.Student;
import com.example.springevidence.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping(value = "/add")
    public String add(Student student){
        return "add";
    }
    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("lists", this.studentRepo.findAll());
        return "index";
    }
    @PostMapping(value = "/add")
    public String save(@Valid Student student, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "add";
        }
        this.studentRepo.save(student);
        model.addAttribute("student", new Student());
        return "add";
    }
    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid Student student, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "edit";
        }
        student.setRegiDate(new Date());
        this.studentRepo.save(student);
        model.addAttribute("student", new Student());
        return "redirect:/";
    }
    @GetMapping(value = "/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id){
        model.addAttribute("student",this.studentRepo.getOne(id));
        return "edit";
    }

}
