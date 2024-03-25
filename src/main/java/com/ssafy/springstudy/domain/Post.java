package com.ssafy.springstudy.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.*;

/**
 * Post 엔티티
 * 1. Post pk key (db 전용)
 * 2. Post 제목
 * 3. Post 내용
 * 4. Member FK (현재 관계는 일대다 관계. 보통 "다" 인 쪽이 FK를 가짐)
 * JPA 에선 FK 값을 가진 값이 @JoinColumn 어노테이션을 통해 관계를 표시함 (조인이 가능해짐)
 */
@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
