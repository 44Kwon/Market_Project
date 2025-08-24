package com.gamemarket.game.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class GameControllerDto {
    @Getter
    @AllArgsConstructor
    public static class Create {
        @NotBlank(message = "게임 이름을 입력해주세요.")
        private String name;
        private String description;
    }

    @Getter
    @AllArgsConstructor
    public static class Update {
        private String name;
        private String description;
    }
}
