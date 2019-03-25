package com.example.chaining.repo;

import com.example.chaining.entity.City;
import com.example.chaining.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City,Long> {

    List<City> findAllByCountry(Country country);
}
