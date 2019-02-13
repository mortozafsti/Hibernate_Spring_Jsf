package com.example.springevidence.Repo;

import com.example.springevidence.Entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepo extends JpaRepository<Nominee, Long> {

}
