package com.example.springevidence.Repo;

import com.example.springevidence.Entity.Ngo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgoRepo extends JpaRepository<Ngo, Long> {
}
