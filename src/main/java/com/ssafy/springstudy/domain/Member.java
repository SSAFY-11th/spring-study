package com.ssafy.springstudy.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.*;

/**
 * 유저 엔티티
 * 1. 유저 pk key (db 전용)
 * 2. 유저 이메일
 * 3. 유저 닉네임
 * 4. 유저 비밀번호
 */

// 엔티티 (JPA의 DB 테이블 선언 같은거. 이 객체를 기반으로 테이블을 생성함)
@Entity
// JPA는 기본생성자를 필요로 함.
// 이유는 프록시 개념이 들어가는데 이 개념은 딥한 개념 (따로 찾아보면 좋을 듯)
// 무조건 public, protected 만 가능한데 public 보다 낮은 protected 로 보통 설정함. (관례)
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {
    // 이 값을 PK로 생성해라
    @Id
    // auto_increment
    @GeneratedValue
    // JPA 는 이름을 기준으로 컬럼명을 정함
    // 전부 id 일 경우에는 혼란이 있을 수 있어 member_id 라고 따로 정의한 것
    @Column(name = "member_id")
    private Long id;
    // 가입시에 없어서는 안되는 값들이기 때문에 NotBlank 를 선언
    // DB 의 not null 이라고 생각하면 될 듯
    @NotBlank
    private String email;
    @NotBlank
    private String nickName;
    @NotBlank
    private String password;

    @NotBlank
    private String role;

    // member
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    /*
    생성을 가독성있게 할 수 있음
    Member member = Member.builder
        .email(email값)
        .nickname(nickname값)
        .password(password값)
        .build();
     */
    @Builder
    public Member(final String email, final String nickName, final String password) {
        this.email = email;
        this.nickName = nickName;
        this.password = password;
    }

}
