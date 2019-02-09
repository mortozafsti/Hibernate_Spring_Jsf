package com.example.secondmvc.Controller;

import com.example.secondmvc.Entity.User;
import com.example.secondmvc.repository.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private userrepo userrepo;


    @GetMapping(value = "/")
    public ModelAndView index(){

        ModelAndView mv = new ModelAndView();
//        mv.addObject("title","Spring MVC! MortozaBD Inc.");
        mv.addObject("user", new User());
        mv.setViewName("index");
        return mv;

    }

   @PostMapping(value = "/")
    public ModelAndView add(@Valid User user){
        ModelAndView mv = new ModelAndView();
//        mv.addObject("title","Spring MVC! MortozaBD Inc.");
        if (user.getName() != null){
            this.userrepo.save(user);
            mv.addObject("msg","Susscessfully Saved");
            mv.addObject("user", new User());
        }
        mv.setViewName("index");
        return mv;

    }

}
