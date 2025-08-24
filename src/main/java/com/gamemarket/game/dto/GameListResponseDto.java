package com.gamemarket.game.dto;

import lombok.Builder;

public class GameListResponseDto {
    private final Long id;
    private final String name;
    private final String description;

    @Builder
    private GameListResponseDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
