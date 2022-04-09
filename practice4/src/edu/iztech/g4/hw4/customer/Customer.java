package edu.iztech.g4.hw4.customer;

import edu.iztech.g4.hw4.exceptions.InvalidCustomerIdException;

public abstract class Customer<T> implements ICustomer<T> {
	private final T customerId;

	public Customer(T customerId) throws InvalidCustomerIdException {
		if (!checkId(customerId))
			throw new InvalidCustomerIdException();
		this.customerId = customerId;
	}

	public T getCustomerId() {
		return customerId;
	}

	public abstract boolean checkId(T id);

}
