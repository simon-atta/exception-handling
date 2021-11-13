package com.dis.exception.handler.excpetion;


public class DateTimeParseException extends BusinessException {

    private DateTimeParseException(String code, String message) {
        super(code, message);
    }

    private DateTimeParseException(String code, String message, String detail) {
        super(code, message, detail);
    }

    public static DateTimeParseException build(String code) {
        return new DateTimeParseException(code, "");
    }

    public static DateTimeParseException build(String code, String message) {
        return new DateTimeParseException(code, message);
    }

    public static DateTimeParseException build(String code, String message, String detail) {
        return new DateTimeParseException(code, message, detail);
    }
}
