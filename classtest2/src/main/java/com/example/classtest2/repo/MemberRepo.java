package com.example.classtest2.repo;

import com.example.classtest2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member,Long> {

//    Member findByM_name(String m_name);
//    Role findByRolename(String rolename);
}
