package com.gm.springsecurity.controller;

import com.gm.springsecurity.entity.Role;
import com.gm.springsecurity.entity.User;
import com.gm.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/user-save")
    public String saveUser() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L));
        roles.add(new Role(3L));
        User user1 = new User("munna","munna@gmail.com", passwordEncoder.encode("1234"), roles);
        userRepo.save(user1);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(new Role(2L));
        User user2 = new User("mehede","mehede@gmail.com", passwordEncoder.encode("12345"), roles2);
        userRepo.save(user2);

        Set<Role> roles3 = new HashSet<>();
        roles3.add(new Role(1L));
        User user3 = new User("milton","milton@gmail.com", passwordEncoder.encode("123456"),  roles3);
        userRepo.save(user3);
        return "success";
    }
}
