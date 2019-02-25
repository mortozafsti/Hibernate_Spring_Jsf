package com.example.classtest2.repo;

import com.example.classtest2.entity.Ngo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgoRepo extends JpaRepository<Ngo, Long> {
}
