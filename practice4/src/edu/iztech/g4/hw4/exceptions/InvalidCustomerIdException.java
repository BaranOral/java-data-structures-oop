package edu.iztech.g4.hw4.exceptions;

public class InvalidCustomerIdException extends InvalidInputException {
	private static final long serialVersionUID = 2489052944919870598L;

	public InvalidCustomerIdException() {
		super("Customer ID should be in correct format.");
	}

	public InvalidCustomerIdException(String message) {
		super(message);
	}

}
