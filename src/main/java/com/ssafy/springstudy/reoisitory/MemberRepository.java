package com.ssafy.springstudy.reoisitory;

import com.ssafy.springstudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemberName(String username);
}