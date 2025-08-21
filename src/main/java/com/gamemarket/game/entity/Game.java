package com.gamemarket.game.entity;

import com.gamemarket.audit.BaseEntity;
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

    private String name;
    private String description;

    @Builder
    private Game(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
