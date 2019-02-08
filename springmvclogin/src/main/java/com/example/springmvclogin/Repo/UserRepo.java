package com.example.springmvclogin.Repo;

import com.example.springmvclogin.Entiry.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
