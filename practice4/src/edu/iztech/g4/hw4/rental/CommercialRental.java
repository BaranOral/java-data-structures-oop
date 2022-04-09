package edu.iztech.g4.hw4.rental;

public class CommercialRental extends Rental<String> {

	public CommercialRental(String customerId, int numberOfDays, String carModel, int carModelYear, double basePrice) {
		super(customerId, numberOfDays * 30, carModel, carModelYear, basePrice);
	}

	@Override
	public String toString() {
		return String.format("%d\t %s\t%-10s\t\t%d\t\t\t%-18s\t%d", getRentalCode(), getCustomerId(), getCustomerType(),
				getNumberOfDays() / 30, getCarModel(), getCarModelYear());
	}

	public String getCustomerType() {
		switch (getCustomerId().charAt(0)) {
			case 'P':
				return "Platinum";
			case 'G':
				return "Gold";
			case 'S':
				return "Silver";
		}
		return "None";
	}

	@Override
	public boolean isMember() {
		return true;
	}

}
