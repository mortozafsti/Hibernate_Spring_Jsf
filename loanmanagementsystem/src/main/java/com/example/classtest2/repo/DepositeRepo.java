package com.example.classtest2.repo;

import com.example.classtest2.entity.Deposite;
import com.example.classtest2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositeRepo extends JpaRepository<Deposite,Long> {

List<Deposite> findAllByMember(Member member);
}

