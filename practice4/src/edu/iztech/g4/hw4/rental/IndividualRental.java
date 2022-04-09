package edu.iztech.g4.hw4.rental;

public class IndividualRental<T> extends Rental<T> {

	public IndividualRental(T customerId, int numberOfDays, String carModel, int carModelYear, double basePrice) {
		super(customerId, numberOfDays, carModel, carModelYear, basePrice);
	}

	@Override
	public String toString() {
		return String.format("%d\t %s\t%b\t\t\t%d\t\t\t%-18s\t%d", getRentalCode(), getCustomerId(), isMember(),
				getNumberOfDays(), getCarModel(), getCarModelYear());
	}

	@Override
	public boolean isMember() {
		return getCustomerId() instanceof String && ((String) getCustomerId()).startsWith("M");
	}
}
