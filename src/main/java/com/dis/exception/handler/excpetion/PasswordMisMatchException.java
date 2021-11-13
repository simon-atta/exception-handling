package com.dis.exception.handler.excpetion;


public class PasswordMisMatchException extends BusinessException {

    private PasswordMisMatchException(String code, String message) {
        super(code, message);
    }

    private PasswordMisMatchException(String code, String message, String detail) {
        super(code, message, detail);
    }

    public static PasswordMisMatchException build(String code) {
        return new PasswordMisMatchException(code, "");
    }

    public static PasswordMisMatchException build(String code, String message) {
        return new PasswordMisMatchException(code, message);
    }

    public static PasswordMisMatchException build(String code, String message, String detail) {
        return new PasswordMisMatchException(code, message, detail);
    }
}
