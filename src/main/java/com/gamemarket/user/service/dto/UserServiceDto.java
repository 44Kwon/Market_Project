package com.gamemarket.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserServiceDto {
    @Getter
    @AllArgsConstructor
    public static class Create {
        private String username;
        private String email;
        private String password;
    }

    @Getter
    @AllArgsConstructor
    public static class UpdatePassword {
        private String currentPw;
        private String newPw;
    }
}
