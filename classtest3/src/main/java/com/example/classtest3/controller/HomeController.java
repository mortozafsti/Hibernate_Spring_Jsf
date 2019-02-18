package com.example.classtest3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/adm")
    public String adminView(){
        return "admin/admin";
    }

    @GetMapping(value = "/sa")
    public String SuperadminView(){
        return "sadmin/sadmin";
    }

    @GetMapping(value = "/se")
    public String secure(){
        return "secure/service";
    }

    @GetMapping(value = "/u")
    public String userView(){
        return "user/u";
    }
}
