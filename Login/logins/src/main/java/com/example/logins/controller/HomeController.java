package com.example.logins.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value ="/admin/h")
    public String admin(){
        return "admin/home";
    }

    @GetMapping(value = "/public/r")
    public String regi(){
        return "public/regi";
    }

    @GetMapping(value = "/user/u")
    public String user(){
        return "user/user";
    }
    @GetMapping(value ={"/","/login/"})
    public String login(){
        return "login";
    }
    @GetMapping(value = "/service/s")
    public String service(){
        return "secure/service";
    }
}
