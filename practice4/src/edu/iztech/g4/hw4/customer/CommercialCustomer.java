package edu.iztech.g4.hw4.customer;

import edu.iztech.g4.hw4.exceptions.InvalidCustomerIdException;
import edu.iztech.g4.hw4.utils.StringUtils;

public abstract class CommercialCustomer extends Customer<String> implements ICommercialCustomer {

	public CommercialCustomer(String customerId) throws InvalidCustomerIdException {
		super(customerId);
	}

	@Override
	public boolean isMember() {
		return true;
	}

	@Override
	public int calculateDiscount() {
		return this.getDiscountPercentage();
	}

	@Override
	public boolean checkId(String id) {
		return (id.length() == 8 && StringUtils.isNumeric(id.substring(1, id.length())))
				&& (id.startsWith("S") || id.startsWith("G") || id.startsWith("P"));
	}

}
