package com.example.classtest2.repo;

import com.example.classtest2.entity.Deposite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositeRepo extends JpaRepository<Deposite,Long> {


}

