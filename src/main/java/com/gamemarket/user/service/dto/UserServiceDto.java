package com.gamemarket.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class UserServiceDto {
    @Getter
    @AllArgsConstructor
    public static class create {
        private String username;
        private String email;
        private String password;
    }

    @Getter
    @AllArgsConstructor
    public static class updatePassword {
        private String currentPw;
        private String newPw;
    }
}
