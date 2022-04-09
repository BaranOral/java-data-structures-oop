package edu.iztech.g4.hw4.customer;

import edu.iztech.g4.hw4.exceptions.InvalidCustomerIdException;

public class PlatinumCommercialCustomer extends CommercialCustomer {

	public PlatinumCommercialCustomer(String customerId) throws InvalidCustomerIdException {
		super(customerId);
	}

	@Override
	public int getDiscountPercentage() {
		return 30;
	}
}
