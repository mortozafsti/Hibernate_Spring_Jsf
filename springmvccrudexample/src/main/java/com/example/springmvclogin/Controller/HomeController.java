package com.example.springmvclogin.Controller;

import com.example.springmvclogin.Entiry.User;
import com.example.springmvclogin.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
//        mv.addObject("title","Spring MVC! MortozaBD Inc.");
        mv.addObject("user", new User());
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/")
    public ModelAndView doShow(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("lists",userRepo.findAll());
        return model;
    }
    @PostMapping(value = "/")
    public ModelAndView doSave(@Valid User user){
        ModelAndView model = new ModelAndView();
        if (user != null){
            this.userRepo.save(user);
            model.addObject("msg","Data Saved Successfully");
            model.addObject("user",new User());
        }
        model.setViewName("index");
        return model;
    }

//    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
//    public ModelAndView doView(@PathVariable("id") Long id){
//        ModelAndView model = new ModelAndView("view");
//        model.addObject("lists", userRepo.findOne());
//        return model;
//    }
}
