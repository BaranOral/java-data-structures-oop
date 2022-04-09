package edu.iztech.g4.hw4.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.iztech.g4.hw4.customer.*;
import edu.iztech.g4.hw4.rental.*;

/*
 * This utility class gets BufferedReader, and reads line by line and initializes the Array using Serializer Class.
 * The Reason all methods are static is because class does not have any instance variables.
 * And also we find unnecessary to initialize utility classes in order to use it.
 */
public class Reader {

	public static ArrayList<Rental<?>> readRentals(BufferedReader bufferedReader) {
		ArrayList<Rental<?>> rentals = new ArrayList<Rental<?>>();
		try {
			String line = bufferedReader.readLine();
			while (line != null) {
				if (line.startsWith(",") || line.isBlank()) {
					line = bufferedReader.readLine();
					continue;
				}
				if (line.startsWith("Individual"))
					rentals.add(Serializer.serializeIndividualRental(line));
				else if (line.startsWith("Commercial"))
					rentals.add(Serializer.serializeCommercialRental(line));

				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rentals;
	}

	public static ArrayList<ICustomer<?>> readCustomers(BufferedReader bufferedReader) {
		ArrayList<ICustomer<?>> customers = new ArrayList<ICustomer<?>>();
		try {
			String line = bufferedReader.readLine();
			while (line != null) {
				if (line.startsWith(",") || line.isBlank()) {
					line = bufferedReader.readLine();
					continue;
				}
				customers.add(Serializer.serializeCustomer(line));
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customers;
	}
}