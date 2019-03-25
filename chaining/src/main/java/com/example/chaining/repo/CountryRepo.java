package com.example.chaining.repo;

import com.example.chaining.entity.City;
import com.example.chaining.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Long> {
}
