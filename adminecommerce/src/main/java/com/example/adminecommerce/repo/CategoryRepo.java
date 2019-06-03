package com.example.adminecommerce.repo;

import com.example.adminecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

    Category findByCatName(String catName);

}
