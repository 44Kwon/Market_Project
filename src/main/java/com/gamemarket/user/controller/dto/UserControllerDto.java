package com.gamemarket.user.controller.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class UserControllerDto {


    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = false) // => 허용되지 않은 값이 추가로 들어오면 튕겨내기
    public static class Create {
        @NotBlank(message = "아이디를 입력해주세요.")
        private String username;
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @NotBlank(message = "이메일을 입력해주세요.")
        private String email;
        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;
    }

    @Getter
    @Setter
    public static class UpdatePassword {
        @NotBlank(message = "기존 비밀번호를 입력해주세요.")
        private String currentPw;
        @NotBlank(message = "새로운 비밀번호를 입력해주세요.")
        private String newPw;
    }
}
