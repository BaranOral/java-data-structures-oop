package edu.iztech.g4.hw4.rental;

import java.util.Random;

import edu.iztech.g4.hw4.exceptions.InvalidModelYearException;

public abstract class Rental<T> {
	private final T customerId;
	private int numberOfDays;
	private String carModel;
	private int carModelYear;
	private double basePrice;
	private double modelYearRatio;
	private final int rentalCode;

	public Rental(T customerId, int numberOfDays, String carModel, int carModelYear, double basePrice) {
		this.customerId = customerId;
		this.numberOfDays = numberOfDays;
		this.carModel = carModel;
		this.carModelYear = carModelYear;
		this.basePrice = basePrice;
		this.modelYearRatio = calculateModelYearRatio();
		this.rentalCode = (new Random()).nextInt(9000000);
	}

	public double getDailyPrice() {
		return modelYearRatio * basePrice;
	}

	public double getTotalPrice() {
		return getDailyPrice() * numberOfDays;
	}

	private double calculateModelYearRatio() {
		try {
			if (carModelYear == 2022) {
				return 1.0;
			} else if (carModelYear == 2020 || carModelYear == 2021) {
				return 0.95;
			} else if (carModelYear >= 2017 && carModelYear <= 2019) {
				return 0.9;
			}
			throw new InvalidModelYearException();
		} catch (InvalidModelYearException e) {
			System.out.println(e);
			return 0.0;
		}
	}

	public abstract boolean isMember();

	@Override
	public abstract String toString();

	public T getCustomerId() {
		return customerId;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public String getCarModel() {
		return carModel;
	}

	public int getCarModelYear() {
		return carModelYear;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public int getRentalCode() {
		return rentalCode;
	}

}
