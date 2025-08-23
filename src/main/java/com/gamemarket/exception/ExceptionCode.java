package com.gamemarket.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

    USER_NOT_FOUND(404, "User not found");

    private int status;
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
