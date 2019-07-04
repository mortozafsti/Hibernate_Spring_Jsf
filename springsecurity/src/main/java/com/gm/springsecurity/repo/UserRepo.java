package com.gm.springsecurity.repo;

import com.gm.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByNameOrEmail(String name, String email);

    User findByName(String name);

}
