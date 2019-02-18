package com.example.classtest3.confiq;

import com.example.classtest3.entity.User;
import com.example.classtest3.repo.UserRepo;
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

        Optional<User> optionalUser = userRepo.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("UserName Not Found"));

        return optionalUser.map(CustomUserDetails::new).get();

    }
}
