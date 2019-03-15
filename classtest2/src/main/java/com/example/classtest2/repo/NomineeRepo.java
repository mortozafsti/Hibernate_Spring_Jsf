package com.example.classtest2.repo;

import com.example.classtest2.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepo extends JpaRepository<Nominee, Long> {


}
