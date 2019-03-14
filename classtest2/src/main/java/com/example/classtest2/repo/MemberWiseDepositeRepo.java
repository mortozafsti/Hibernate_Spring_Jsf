package com.example.classtest2.repo;

import com.example.classtest2.entity.MemberWiseDeposite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberWiseDepositeRepo extends JpaRepository<MemberWiseDeposite, Long> {

    MemberWiseDeposite findByLoan_LoanCode(String loanCode);
}
