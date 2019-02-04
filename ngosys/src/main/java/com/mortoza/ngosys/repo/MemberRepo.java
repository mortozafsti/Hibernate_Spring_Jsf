package com.mortoza.ngosys.repo;

import com.mortoza.ngosys.entity.Member;
import com.mortoza.ngosys.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {

}
