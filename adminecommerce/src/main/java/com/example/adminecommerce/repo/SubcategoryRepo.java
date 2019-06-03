package com.example.adminecommerce.repo;

import com.example.adminecommerce.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepo extends JpaRepository<Subcategory,Long> {
    Subcategory findBySubcatName(String subcatName);
}
