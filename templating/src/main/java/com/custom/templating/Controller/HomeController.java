package com.custom.templating.Controller;

import com.custom.templating.Entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayHomr(Role role) {
        return "index";
    }

    @GetMapping(value = "/add-role")
    public String displayRole(Role role) {
        return "add-role";
    }

}
