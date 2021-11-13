package com.dis.exception.handler.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ApiFieldError {

	private String field;
	private String code;
	private Object rejectedValue;
	private String translatedMessage;
	
	public ApiFieldError() {
	}

	public ApiFieldError(String field, String code, Object rejectedValue) {
		super();
		this.field = field;
		this.code = code;
		this.rejectedValue = rejectedValue;
	}

	public ApiFieldError(String field, String code, Object rejectedValue, String translatedMessage) {
		super();
		this.field = field;
		this.code = code;
		this.rejectedValue = rejectedValue;
		this.translatedMessage = translatedMessage;
	}
}
