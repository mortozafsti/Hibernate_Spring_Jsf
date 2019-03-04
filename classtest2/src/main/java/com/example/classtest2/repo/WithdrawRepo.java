package com.example.classtest2.repo;

import com.example.classtest2.entity.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawRepo extends JpaRepository<Withdraw, Long> {

}
