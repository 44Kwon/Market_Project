package com.gamemarket.game.entity;

import com.gamemarket.audit.BaseEntity;
import com.gamemarket.game.dto.GameListResponseDto;
import com.gamemarket.game.dto.GameResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @SequenceGenerator(name = "game_seq", sequenceName = "game_seq", allocationSize = 50)
    @Column(name = "game_id")
    private Long id;

    @Column(nullable = false, unique = true)
    //unique 제약조건(인덱싱)
    private String name;
    private String description;

    @Builder
    private Game(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // 업데이트용 메서드
    public void updateGame(String name, String description) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
        if (description != null) {
            this.description = description;
        }
    }

    // Entity -> DTO
    public GameResponseDto toResponseDto() {
        return GameResponseDto.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .createdAt(this.getCreatedAt())
                .updatedAt(this.getUpdatedAt())
                .build();
    }

    public GameListResponseDto toListResponseDto() {
        return GameListResponseDto.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .build();
    }
}
