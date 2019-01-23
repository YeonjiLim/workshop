package com.ssafy.edu.java;

public class ISBNNotFoundException extends Exception {

	public ISBNNotFoundException() {
		super("ISBN이 존재하지 않습니다.");
	}

	public ISBNNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ISBNNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ISBNNotFoundException(String message) {
		super(message);
	}

	public ISBNNotFoundException(Throwable cause) {
		super(cause);
	}

}
