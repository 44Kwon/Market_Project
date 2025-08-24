package com.gamemarket.game.service.dto;


import com.gamemarket.game.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class GameServiceDto {
    @Getter
    @AllArgsConstructor
    public static class CreateAndUpdateDto {
        private String name;
        private String description;

        public Game toGame() {
            return Game.builder()
                    .name(name)
                    .description(description)
                    .build();
        }
    }
}
