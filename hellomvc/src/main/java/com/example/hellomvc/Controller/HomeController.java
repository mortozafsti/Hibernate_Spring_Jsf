package com.example.hellomvc.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String home(){
        return "Home MVC";
    }
    @GetMapping(value = "/test")
    public String test(){
        return "Hello Test MVC";
    }
}
