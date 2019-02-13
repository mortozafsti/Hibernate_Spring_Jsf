package com.example.springevidence.Repo;

import com.example.springevidence.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member,Long> {

//    Member findByM_name(String m_name);
//    Role findByRolename(String rolename);
}
