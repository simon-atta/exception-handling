package com.dis.exception.handler.excpetion;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BusinessException extends RuntimeException {

	private String code;

	private String message;

	private String detail;

	public BusinessException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public BusinessException(String code, String message, String detail) {
		this.code = code;
		this.message = message;
		this.detail = detail;
	}

}
