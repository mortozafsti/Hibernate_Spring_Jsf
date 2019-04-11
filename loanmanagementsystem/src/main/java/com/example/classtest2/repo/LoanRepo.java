package com.example.classtest2.repo;

import com.example.classtest2.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {


    Loan findByLoanCode(String loanCode);

 List<Loan> findAllByl_brance(String l_brance);



}
