package com.gamemarket.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

    //유저
    USER_USERNAME_DUPLICATED(409, "이미 사용 중인 아이디입니다"),
    USER_EMAIL_DUPLICATED(409, "이미 사용 중인 이메일입니다"),
    USER_NOT_FOUND(404, "유저가 존재하지 않습니다"),

    //비밀번호
    PASSWORD_SAME_AS_OLD(400, "새로운 비밀번호는 현재 비밀번호와 달라야 합니다"),

    //게임
    GAME_ALREADY_EXIST(409, "이미 등록된 게임입니다"),
    GAME_NOT_FOUND(404, "게임이 존재하지 않습니다"),

    //관리자가 아닐시
    INVALID_ACCESS(403, "해당 권한이 없습니다");

    private int status;
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
