package com.dis.exception.handler.excpetion;


public class NotEnoughPermissionException extends BusinessException {

    private NotEnoughPermissionException(String code, String message) {
        super(code, message);
    }

    private NotEnoughPermissionException(String code, String message, String detail) {
        super(code, message, detail);
    }

    public static NotEnoughPermissionException build(String code) {
        return new NotEnoughPermissionException(code, "");
    }

    public static NotEnoughPermissionException build(String code, String message) {
        return new NotEnoughPermissionException(code, message);
    }

    public static NotEnoughPermissionException build(String code, String message, String detail) {
        return new NotEnoughPermissionException(code, message, detail);
    }
}
