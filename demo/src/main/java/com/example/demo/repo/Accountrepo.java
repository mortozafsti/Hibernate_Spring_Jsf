package com.example.demo.repo;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Accountrepo  extends JpaRepository<Account, Long>{

}
