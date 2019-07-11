package com.gm.springsecurity.repo;

import com.gm.springsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

    Optional<Role> findByRolename(String rolename);
}