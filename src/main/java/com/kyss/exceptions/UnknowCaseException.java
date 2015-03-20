package com.kyss.exceptions;

/**
 * @author Mathieu SAUVAGE
 */
public class UnknowCaseException extends RuntimeException {
	//<editor-fold desc="Builder">
	public UnknowCaseException() {
	}

	public UnknowCaseException(String message) {
		super(message);
	}

	public UnknowCaseException(String message, Throwable cause) {
		super(message,
			  cause);
	}

	public UnknowCaseException(Throwable cause) {
		super(cause);
	}

	public UnknowCaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message,
			  cause,
			  enableSuppression,
			  writableStackTrace);
	}
	//</editor-fold>
}
