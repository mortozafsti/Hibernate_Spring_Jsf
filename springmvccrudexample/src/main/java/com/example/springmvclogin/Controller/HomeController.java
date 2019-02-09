package com.example.springmvclogin.Controller;

import com.example.springmvclogin.Entiry.User;
import com.example.springmvclogin.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/add")
    public String add(User user){
        return "add";
    }

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("lists",this.userRepo.findAll());
        return "index";
    }

    @PostMapping(value = "/add")
    public String doSave(@Valid User user,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "add";
        }
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        return "add";
    }
    @PostMapping(value = "/edit/{id}")
    public String doEdit(@Valid User user,BindingResult bindingResult,Model model,@PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "edit";
        }
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        return "redirect:/";
    }
    @GetMapping(value = "/edit/{id}")
    public String deitView(Model model,@PathVariable("id") Long id){
        model.addAttribute("user",this.userRepo.getOne(id));
        return "edit";
    }
    @GetMapping(value = "/del/{id}")
    public String doDelete(Model model,@PathVariable("id") Long id){
        if (id != null){
            this.userRepo.deleteById(id);
        }
        return "redirect:/";
    }

}
