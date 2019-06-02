package com.example.adminecommerce.config;


import com.example.adminecommerce.entity.User;
import com.example.adminecommerce.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepo.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));

        return optionalUser.map(CustomUserDetails::new).get();

    }
}
