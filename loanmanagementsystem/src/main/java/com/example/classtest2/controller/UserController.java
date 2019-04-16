package com.example.classtest2.controller;

import com.example.classtest2.entity.Role;
import com.example.classtest2.entity.User;
import com.example.classtest2.repo.RoleRepo;
import com.example.classtest2.repo.UserRepo;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/listuser")
    public String index(Model model) {
        model.addAttribute("userlist", this.userRepo.findAll());
        return "user/listuser";
    }


    @GetMapping(value = "/adduser")
    public String addRole(User user, Model model) {
        model.addAttribute("addlisthome", this.roleRepo.findAll());
        return "user/adduser";
    }

    @PostMapping(value = "/adduser")
    public String saveUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("addlisthome", this.roleRepo.findAll());
            return "user/adduser";
        }
        if (user != null) {
            User user1 = this.userRepo.findByUsername(user.getUsername());
            if (user1 != null) {
                model.addAttribute("exitMsg", "UserName is Already Exist");
            } else {
//            String username = user.getEmail().split("\\@")[0];

//            user.setUsername(username);

                user.setStatus(true);

                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setConformationToken(UUID.randomUUID().toString());
                this.userRepo.save(user);
                model.addAttribute("user", new User());
                model.addAttribute("addlisthome", this.roleRepo.findAll());
                model.addAttribute("succ", "Congratulation Data Save");
            }

        }
        return "user/adduser";
    }
}