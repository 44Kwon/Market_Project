package com.gamemarket.user.entity;

import com.gamemarket.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    // DB에서 user_seq라는 시퀀스를 사용하여 ID를 생성한다. 만약 없다면 시퀀스 생성한다
    // allocationSize는 시퀀스가 증가하는 크기를 의미한다 + 가져오는 시퀀스 크기
    // allocationSize 50으로 두면 Batch Insert 시 성능을 높아짐(1이면 IDENTITY 전략과 비슷)
    // 이 시퀀스 설정은 ddl-auto=update 등 설정 시 생성 가능, 없으면 오류
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 50)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String email;
    private String password;
    private Integer point; // 유저 포인트
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        USER,ADMIN
    }

    @Builder
    private User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.point = 500; // 기본 포인트 500으로 설정
        this.role = (role == null) ? Role.USER : role;
    }

    //비밀번호 변경
    public void updatePassword(String newPassword){
        this.password = newPassword;
    }
}
