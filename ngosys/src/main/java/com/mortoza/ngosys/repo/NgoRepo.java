package com.mortoza.ngosys.repo;

import com.mortoza.ngosys.entity.Ngo;
import com.mortoza.ngosys.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgoRepo extends JpaRepository<Ngo,Long> {

}
