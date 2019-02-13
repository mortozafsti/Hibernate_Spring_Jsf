package com.example.springevidence.Repo;

import com.example.springevidence.Entity.Deposite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositeRepo extends  JpaRepository<Deposite,Long>{

}

