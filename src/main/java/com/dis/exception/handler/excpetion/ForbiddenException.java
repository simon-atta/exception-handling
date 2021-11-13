package com.dis.exception.handler.excpetion;


public class ForbiddenException extends BusinessException {
    private ForbiddenException(String code, String message) {
        super(code, message);
    }

    private ForbiddenException(String code, String message, String detail) {
        super(code, message, detail);
    }

    public static ForbiddenException build(String code) {
        return new ForbiddenException(code, "");
    }

    public static ForbiddenException build(String code, String message) {
        return new ForbiddenException(code, message);
    }

    public static ForbiddenException build(String code, String message, String detail) {
        return new ForbiddenException(code, message, detail);
    }
}
