package com.ssafy.edu.java;

public class QuantityException extends Exception {

	public QuantityException() {
		super("도서의 수량이 부족합니다.");
	}

	public QuantityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public QuantityException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuantityException(String message) {
		super(message);
	}

	public QuantityException(Throwable cause) {
		super(cause);
	}

}
