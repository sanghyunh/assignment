package com.assignment.constant;

import lombok.Getter;

@Getter
public enum Errors {

    GENERAL_UNKNOWN(-10, "에러", "Unknown Error"),
    JWT_DECRYPT_ERROR(-5001, "에러", "JWT DECRYPT ERROR"),
    OAUTH_TOKEN_NOT_FOUND(-5002, "에러", "TOKEN 정보가 없습니다."),
    OAUTH_TOKEN_TIMEOUT(-5003, "에러", "TOKEN 만료 (refresh)"),
    OAUTH_TOKEN_ERROR(-5004, "에러", "잘못된 TOKEN 입니다"),
    TOKEN_TYPE_IS_NOT_ALLOWED(-5005, "에러", "TOKEN TYPE IS NOT ALLOWED"),
    TEST(-9999, "에러", "임시 에러");

    private final int code;
    private final String title;
    private final String message;

    Errors(int code, String title, String message) {
        this.code = code;
        this.title = title;
        this.message = message;
    }
}
