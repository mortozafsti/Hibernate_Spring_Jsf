package com.mahbub.webmvcfinalcrud.repo;

import com.mahbub.webmvcfinalcrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepo extends JpaRepository<Student, Long> {
}
