package com.dis.exception.handler.excpetion;


public class NotFoundException extends BusinessException {

    private NotFoundException(String code, String message) {
        super(code, message);
    }

    private NotFoundException(String code, String message, String detail) {
        super(code, message, detail);
    }

    public static NotFoundException build(String code) {
        return new NotFoundException(code, "");
    }

    public static NotFoundException build(String code, String message) {
        return new NotFoundException(code, message);
    }

    public static NotFoundException build(String code, String message, String detail) {
        return new NotFoundException(code, message, detail);
    }
}
