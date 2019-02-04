package com.mortoza.ngosys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayHomr() {
        return "index";
    }


    @GetMapping(value = "/add-role.jsf")
    public String displayRoleAdd() {
        return "add-role";
    }

    @GetMapping(value = "/add-user.jsf")
    public String displayUserAdd() {
        return "add-user";
    }

    @GetMapping(value = "/add-ngo.jsf")
    public String displayNgoAdd() {
        return "add-ngo";
    }

    @GetMapping(value = "/add-nominee.jsf")
    public String displayNomineeAdd() {
        return "add-nominee";
    }


    @GetMapping(value = "/add-member.jsf")
    public String displayMemberAdd() {
        return "add-member";
    }
}
