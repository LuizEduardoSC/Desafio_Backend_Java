package com.empresa.backend.exception;

public class ParceiroException extends RuntimeException {
	private static final long serialVersionUID = 1L; // ← Adicione esta linha

	public ParceiroException(String message) {
		super(message);
	}

	public ParceiroException(String message, Throwable cause) {
		super(message, cause);
	}
}