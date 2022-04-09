package edu.iztech.g4.hw4.utils;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import edu.iztech.g4.hw4.customer.*;
import edu.iztech.g4.hw4.exceptions.*;
import edu.iztech.g4.hw4.rental.*;

/**
 * This utility class gets String line from Reader, and tokenizes and return
 * class using StringTokenizer. Reason all methods are static is, class does not
 * have any instance variables. And also we find unnecessary to initialize
 * utility classes in order to use it.
 */
public class Serializer {

	public static IndividualRental<?> serializeIndividualRental(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		IndividualRental<?> tempRental = null;
		try {
			st.nextToken();

			String id = st.nextToken();
			int numberOfDays = Integer.parseInt(st.nextToken());

			String carModel = st.nextToken();
			int carModelYear = Integer.parseInt(st.nextToken());
			double basePrice = Double.parseDouble(st.nextToken());

			if (id.startsWith("M"))
				tempRental = new IndividualRental<String>(id, numberOfDays, carModel, carModelYear, basePrice);
			else
				tempRental = new IndividualRental<Long>(Long.parseLong(id), numberOfDays, carModel, carModelYear,
						basePrice);
		} catch (NoSuchElementException | NumberFormatException e) {
			e.printStackTrace();
		}
		return tempRental;
	}

	public static CommercialRental serializeCommercialRental(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		CommercialRental tempRental = null;
		try {
			st.nextToken();

			String id = st.nextToken();
			int numberOfDays = Integer.parseInt(st.nextToken());

			String carModel = st.nextToken();
			int carModelYear = Integer.parseInt(st.nextToken());
			double basePrice = Double.parseDouble(st.nextToken());

			tempRental = new CommercialRental(id, numberOfDays, carModel, carModelYear, basePrice);
		} catch (NoSuchElementException | NumberFormatException e) {
			e.printStackTrace();
		}
		return tempRental;
	}

	public static ICustomer<?> serializeCustomer(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		try {
			String type = st.nextToken();
			String id = st.nextToken();

			if (type.equals("Individual")) {
				if (id.startsWith("M"))
					return new IndividualCustomer<String>(id);
				return new IndividualCustomer<Long>(Long.parseLong(id));

			} else if (type.equals("Commercial")) {
				switch (id.charAt(0)) {
					case 'S':
						return new SilverCommercialCustomer(id);
					case 'G':
						return new GoldCommercialCustomer(id);
					case 'P':
						return new PlatinumCommercialCustomer(id);
				}
			}
		} catch (InvalidCustomerIdException | NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

}
