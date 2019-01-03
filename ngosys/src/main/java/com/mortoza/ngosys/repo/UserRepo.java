package com.mortoza.ngosys.repo;

import com.mortoza.ngosys.entity.Role;
import com.mortoza.ngosys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
