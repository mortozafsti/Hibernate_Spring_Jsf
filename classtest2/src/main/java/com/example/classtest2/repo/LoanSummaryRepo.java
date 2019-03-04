package com.example.classtest2.repo;

import com.example.classtest2.entity.LoanSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanSummaryRepo extends JpaRepository<LoanSummary, Long> {

}
