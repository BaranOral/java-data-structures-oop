package edu.iztech.g4.hw4.customer;

import edu.iztech.g4.hw4.exceptions.InvalidCustomerIdException;
import edu.iztech.g4.hw4.utils.StringUtils;

public class IndividualCustomer<T> extends Customer<T> {

	public IndividualCustomer(T customerId) throws InvalidCustomerIdException {
		super(customerId);
	}

	@Override
	public boolean isMember() {
		return super.getCustomerId() instanceof String;
	}

	@Override
	public int calculateDiscount() {
		return this.isMember() ? 10 : 0;
	}

	@Override
	public boolean checkId(T id) {
		if (id instanceof String) {
			String tempId = (String) id;
			return tempId.length() == 12 && tempId.startsWith("M")
					&& StringUtils.isNumeric(tempId.substring(1, tempId.length()));
		}
		return (String.valueOf(id).length() == 11);
	}

}
