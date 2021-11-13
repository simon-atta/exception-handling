package com.dis.exception.handler.excpetion;


public class UnauthorizedException extends BusinessException {

    private UnauthorizedException(String code, String message) {
        super(code, message);
    }

    private UnauthorizedException(String code, String message, String detail) {
        super(code, message, detail);
    }

    public static UnauthorizedException build(String code) {
        return new UnauthorizedException(code, "");
    }

    public static UnauthorizedException build(String code, String message) {
        return new UnauthorizedException(code, message);
    }

    public static UnauthorizedException build(String code, String message, String detail) {
        return new UnauthorizedException(code, message, detail);
    }

}
