package com.example.demo.controller;


import com.example.demo.entity.Account;
import com.example.demo.repo.Accountrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private Accountrepo repo;

    @GetMapping(value = "/account-ist")
    public List<Account> getAccountList(){

        return repo.findAll();
    }

}
