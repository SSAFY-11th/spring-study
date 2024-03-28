package com.ssafy.springstudy.repository;

import com.ssafy.springstudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String username);
}
