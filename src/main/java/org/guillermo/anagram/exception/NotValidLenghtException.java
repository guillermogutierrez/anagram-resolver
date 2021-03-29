package org.guillermo.anagram.exception;

public class NotValidLenghtException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5597291282949156809L;

	public NotValidLenghtException(String errorMessage) {

		super(errorMessage);
	}
}
