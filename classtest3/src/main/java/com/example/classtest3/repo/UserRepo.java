package com.example.classtest3.repo;

import com.example.classtest3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {


    Optional<User> findByUsernameOrEmail(String username,String email);
}
