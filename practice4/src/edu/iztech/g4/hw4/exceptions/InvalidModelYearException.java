package edu.iztech.g4.hw4.exceptions;

public class InvalidModelYearException extends InvalidInputException {
	private static final long serialVersionUID = -5832114523146150713L;

	public InvalidModelYearException() {
		super("Model Year should be between 2022 and 2017.");
	}

}
