package com.gamemarket.pointhistory.entity;

import com.gamemarket.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "point_histories")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PointHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "point_history_id")
    private Long id;

    private Integer change_amount;
    private Integer remaining_point;

    @CreationTimestamp
    private LocalDateTime created_at;

    @Enumerated(EnumType.STRING)
    private PointType pointType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public enum PointType {
        CHARGE,  PURCHASE, REWARD   // 충전, 구매, 보상
    }
}
