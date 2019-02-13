package com.example.springevidence.Repo;

import com.example.springevidence.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {

}
