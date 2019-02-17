package com.custom.templating.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayHomr() {
        return "index";
    }

    @GetMapping(value = "/add-role.html")
    public String displayRole() {
        return "add-role";
    }
    @GetMapping(value = "/dash")
    public String dashBoard() {
        return "dashboard";
    }

}
