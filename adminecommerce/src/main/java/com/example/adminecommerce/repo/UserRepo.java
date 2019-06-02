package com.example.adminecommerce.repo;

import com.example.adminecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUserNameOrEmail(String username, String email);
    User findByUserName(String userName);
}
