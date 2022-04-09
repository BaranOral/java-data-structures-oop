package edu.iztech.g4.hw4.customer;

import edu.iztech.g4.hw4.exceptions.InvalidCustomerIdException;

public class SilverCommercialCustomer extends CommercialCustomer {

	public SilverCommercialCustomer(String customerId) throws InvalidCustomerIdException {
		super(customerId);
	}

	@Override
	public int getDiscountPercentage() {
		return 20;
	}
}
