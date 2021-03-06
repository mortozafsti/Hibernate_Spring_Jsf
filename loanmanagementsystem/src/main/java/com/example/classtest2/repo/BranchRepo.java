package com.example.classtest2.repo;

import com.example.classtest2.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {
Branch findByBranchName(String BranchName);

}
