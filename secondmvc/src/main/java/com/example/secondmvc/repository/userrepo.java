package com.example.secondmvc.repository;

import com.example.secondmvc.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepo  extends JpaRepository<User, Long> {
}
