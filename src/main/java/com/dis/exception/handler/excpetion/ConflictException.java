package com.dis.exception.handler.excpetion;


public class ConflictException extends BusinessException {

	private ConflictException(String code, String message) {
		super(code, message);
	}

	private ConflictException(String code, String message, String detail) {
		super(code, message, detail);
	}

	public static ConflictException build(String code) {
		return new ConflictException(code, "");
	}

	public static ConflictException build(String code, String message) {
		return new ConflictException(code, message);
	}

	public static ConflictException build(String code, String message, String detail) {
		return new ConflictException(code, message, detail);
	}
}
