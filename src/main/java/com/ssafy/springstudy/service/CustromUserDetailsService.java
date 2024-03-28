package com.ssafy.springstudy.service;

import com.ssafy.springstudy.domain.Member;
import com.ssafy.springstudy.dto.CustomUserDetails;
import com.ssafy.springstudy.reoisitory.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustromUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 로그인 페이지를 통해 아이디와 비밀번호를 post 요청시 스프링 시큐리티는 데이터베이스에
        // 저장된 회원 정보를 조회 후 비밀번호를 검증하고 서버 세션 저장소에 해당 아이디에 대한 세션을 저장한다.

        Member memberData = memberRepository.findByMemberName(username);
        if(memberData != null) {

            return new CustomUserDetails(memberData);
        }

        return null;
    }
}

