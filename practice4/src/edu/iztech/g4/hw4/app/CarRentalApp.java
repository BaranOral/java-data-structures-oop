package edu.iztech.g4.hw4.app;

import java.util.ArrayList;

import edu.iztech.g4.hw4.customer.ICustomer;
import edu.iztech.g4.hw4.rental.Rental;
import edu.iztech.g4.hw4.utils.FileIO;
import edu.iztech.g4.hw4.utils.Reader;

public class CarRentalApp {

	public static void main(String[] args) {
		ArrayList<ICustomer<?>> customers = Reader.readCustomers(FileIO.getBufferedReader("HW4_Rentals.csv"));
		ArrayList<Rental<?>> rentals = Reader.readRentals(FileIO.getBufferedReader("HW4_Rentals.csv"));

		CarRentalQuery query = new CarRentalQuery(customers, rentals);

		query.displayStatistics();
		query.displayTables();
	}

}
