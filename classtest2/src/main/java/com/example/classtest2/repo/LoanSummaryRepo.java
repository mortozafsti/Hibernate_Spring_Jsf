package com.example.classtest2.repo;

import com.example.classtest2.entity.LoanSummary;
import com.example.classtest2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanSummaryRepo extends JpaRepository<LoanSummary, Long> {
Optional<LoanSummary> findByMember(Member member);
}
