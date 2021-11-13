package com.dis.exception.handler.excpetion;


public class RoleNotFoundException extends BusinessException {

    private RoleNotFoundException(String code, String message) {
        super(code, message);
    }

    private RoleNotFoundException(String code, String message, String detail) {
        super(code, message, detail);
    }

    public static RoleNotFoundException build(String code) {
        return new RoleNotFoundException(code, "");
    }

    public static RoleNotFoundException build(String code, String message) {
        return new RoleNotFoundException(code, message);
    }

    public static RoleNotFoundException build(String code, String message, String detail) {
        return new RoleNotFoundException(code, message, detail);
    }
}
