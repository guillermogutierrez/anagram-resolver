package org.guillermo.anagram.exception;

public class NotValidKeyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2700158871417566875L;

	public NotValidKeyException(String errorMessage) {

		super(errorMessage);
	}
}
