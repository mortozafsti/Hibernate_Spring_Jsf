package com.example.classtest.repo;

import com.example.classtest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rolerepo extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);
}
