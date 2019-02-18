package com.example.classtest2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/adm")
    public String AdminView(){
        return "admin/admin";
    }

    @GetMapping(value = "/sa")
    public String superAdminView(){
        return "sadmin/sadmin";
    }

    @GetMapping(value = "/se")
    public String secureView(){
        return "secure/service";
    }

    @GetMapping(value = "/u")
    public String user(){
        return "user/u";
    }
}
