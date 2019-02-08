package com.example.springmvclogin.Controller;

import com.example.springmvclogin.Entiry.User;
import com.example.springmvclogin.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/")
    public ModelAndView doShow(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("lists",userRepo.findAll());
        return model;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("id") Long id,@RequestParam("name") String name,@RequestParam("password") String pass,@RequestParam("email") String email){
        ModelAndView model = new ModelAndView();
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(pass);
        user.setEmail(email);
        userRepo.save(user);
        return model;
    }
}
