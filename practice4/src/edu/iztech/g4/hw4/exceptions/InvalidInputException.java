package edu.iztech.g4.hw4.exceptions;

public abstract class InvalidInputException extends Exception {
	private static final long serialVersionUID = 4101258456897851127L;

	public InvalidInputException(String message) {
		super(message);
	}

}
