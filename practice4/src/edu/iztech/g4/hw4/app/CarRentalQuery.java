package edu.iztech.g4.hw4.app;

import java.util.ArrayList;

import edu.iztech.g4.hw4.customer.*;
import edu.iztech.g4.hw4.rental.*;

public class CarRentalQuery {
	private ArrayList<Rental<?>> rentals;
	private ArrayList<ICustomer<?>> customers;

	public CarRentalQuery(ArrayList<ICustomer<?>> customers, ArrayList<Rental<?>> rentals) {
		this.rentals = rentals;
		this.customers = customers;
	}

	public void displayStatistics() {
		System.out.println("Welcome!");
		System.out.printf("Total number of cars rented: %s\n", calculateNumberOfCarsRented());
		System.out.printf("Total number of commercial rentals: %s\n", calculateNumberOfCommercialRentals());
		System.out.printf("Total number of commercial rental-month: %s\n", calculateNumberOfCommercialRentalPerMonth());
		System.out.printf("Total number of individual rentals: %s\n", calculateNumberOfIndividualRentals());
		System.out.printf("Total number of individual rental-day: %s\n", calculateNumberOfIndividualRentalsPerMonth());
		System.out.printf("Total number of rentals of individual non-member customers: %s\n",
				calculateNumberOfIndividualNonMemberCustomerRentals());
		System.out.printf("Total number of rentals of individual member customers: %s\n",
				calculateNumberOfIndividualMemberCustomerRentals());
		System.out.printf("Total number of rentals of silver commercial customers: %s\n",
				calculateNumberOfRentalsOfSilverCommercialCustomers());
		System.out.printf("Total number of rentals of gold commercial customers: %s\n",
				calculateNumberOfRentalsOfGoldCommercialCustomers());
		System.out.printf("Total number of rentals of platinum commercial customers: %s\n",
				calculateNumberOfRentalsOfPlatinumCommercialCustomers());
	}

	public void displayTables() {
		System.out.println("\nIndividual Rentals:");
		System.out.printf(
				"No  Rental Code\t Customer ID\tisMember\t\tNumber of Days\t\tCar Model\t\tModel Year\tRental Price\n");
		int count = 1;
		for (Rental<?> r : rentals) {
			if (r instanceof IndividualRental) {
				System.out.printf("%d   %s\t\t%.2f\n", count, r, calculateRentalPrice(r));
				count++;
			}
		}
		System.out.println("\nCommercial Rentals:");
		System.out.printf(
				"No  Rental Code\t Customer ID\tCustomer Type\t\tNumber of Months\tCar Model\t\tModel Year\tRental Price\n");
		count = 1;
		for (Rental<?> r : rentals) {
			if (r instanceof CommercialRental) {
				System.out.printf("%d   %s\t\t%.2f\n", count, r, calculateRentalPrice(r));
				count++;
			}
		}
	}

	private double calculateRentalPrice(Rental<?> r) {
		ICustomer<?> customer = getCustomerById(r.getCustomerId());
		return (r.getTotalPrice() * (100 - customer.calculateDiscount())) / 100;
	}

	private int calculateNumberOfCarsRented() {
		return rentals.size();
	}

	private int calculateNumberOfCommercialRentals() {
		return (int) rentals.stream().filter(r -> r instanceof CommercialRental).count();
	}

	private int calculateNumberOfCommercialRentalPerMonth() { // I calculated this by summing up the number of days
		// Collection's reduce to sum up all Commercial Rental objects' number of days.
		return rentals.stream().filter(r -> r instanceof CommercialRental).reduce(0,
				(result, rental) -> result + (rental.getNumberOfDays() / 30), Integer::sum);
	}

	private int calculateNumberOfIndividualRentals() {
		return (int) rentals.stream().filter(r -> r instanceof IndividualRental).count();
	}

	private int calculateNumberOfIndividualRentalsPerMonth() { // I calculated this by summing up the number of days
		// Collection's reduce to sum up all Individual Rental objects' number of days.
		return rentals.stream().filter(r -> r instanceof IndividualRental).reduce(0,
				(result, rental) -> result + rental.getNumberOfDays(), Integer::sum);
	}

	private int calculateNumberOfIndividualNonMemberCustomerRentals() {
		return (int) rentals.stream()
				.filter(r -> r instanceof IndividualRental && !getCustomerById(r.getCustomerId()).isMember()).count();
	}

	private int calculateNumberOfIndividualMemberCustomerRentals() {
		return (int) rentals.stream()
				.filter(r -> r instanceof IndividualRental && getCustomerById(r.getCustomerId()).isMember()).count();
	}

	private int calculateNumberOfRentalsOfSilverCommercialCustomers() {
		return (int) rentals.stream()
				.filter(r -> getCustomerById(r.getCustomerId()) instanceof SilverCommercialCustomer).count();
	}

	private int calculateNumberOfRentalsOfGoldCommercialCustomers() {
		return (int) rentals.stream().filter(r -> getCustomerById(r.getCustomerId()) instanceof GoldCommercialCustomer)
				.count();
	}

	private int calculateNumberOfRentalsOfPlatinumCommercialCustomers() {
		return (int) rentals.stream()
				.filter(r -> getCustomerById(r.getCustomerId()) instanceof PlatinumCommercialCustomer).count();
	}

	private ICustomer<?> getCustomerById(Object customerId) {
		return customers.stream().filter(c -> isIdEqual(c.getCustomerId(), customerId)).findFirst().orElse(null);
	}

	private boolean isIdEqual(Object id1, Object id2) {
		return id1.getClass() == id2.getClass() ? id1.equals(id2) : false;
	}

}
