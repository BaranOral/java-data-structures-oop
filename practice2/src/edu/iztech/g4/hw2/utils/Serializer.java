package edu.iztech.g4.hw2.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import edu.iztech.g4.hw2.applicant.*;
import edu.iztech.g4.hw2.document.*;
import edu.iztech.g4.hw2.financial.FinancialStatus;
import edu.iztech.g4.hw2.passport.Passport;
import edu.iztech.g4.hw2.photo.Photo;

/*
 * This utility class gets String line from Reader, and tokenizes and return class using StringTokenizer.
 * Reason all methods are static is, class does not have any instance variables.
 * And also we find unnecessary to initialize utility classes in order to use it.
 */
public class Serializer {

	public static Photo serializePhoto(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		Photo tempPhoto = null;
		try {
			st.nextToken();

			int id = Integer.parseInt(st.nextToken());
			String resolution = st.nextToken();
			String position = st.nextToken();

			tempPhoto = new Photo(id, resolution, position);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempPhoto;
	}

	public static Passport serializePassport(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		Passport tempPassport = null;
		try {
			st.nextToken();

			int id = Integer.parseInt(st.nextToken());
			String passportNumber = st.nextToken();

			/*
			 * According to: https://docs.oracle.com/javase/7/docs/api/java/util/Date.html
			 * Initializing Date using String is deprecated since Java 7. So I used
			 * DateFormat Class in java.text as suggested in the doc.
			 */
			DateFormat parser = new SimpleDateFormat("yy-MM-dd", Locale.ENGLISH);

			String expirationString = st.nextToken();
			Date expirationDate = parser.parse(expirationString);

			tempPassport = new Passport(id, passportNumber, expirationDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempPassport;
	}

	public static FinancialStatus serializeFinancialStatus(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		FinancialStatus tempFinancialStatus = null;
		try {
			st.nextToken();

			int id = Integer.parseInt(st.nextToken());
			int income = Integer.parseInt(st.nextToken());
			int savings = Integer.parseInt(st.nextToken());

			tempFinancialStatus = new FinancialStatus(id, income, savings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempFinancialStatus;
	}

	public static Document serializeDocument(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		try {
			st.nextToken();

			int id = Integer.parseInt(st.nextToken());
			String documentType = st.nextToken();

			switch (documentType) {
				case "LA":
					int duration = Integer.parseInt(st.nextToken());
					return new LetterOfAcceptance(id, duration);
				case "GC":
					return new GreenCard(id);
				case "IL":
					return new InvitationLetter(id);
				default:
					return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Applicant serializeApplicant(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		try {
			st.nextToken();

			String tempId = st.nextToken();
			String firstTwoChar = tempId.substring(0, 2);
			int id = Integer.parseInt(tempId);

			String name = st.nextToken();

			switch (firstTwoChar) {
				case "11":
					return new TouristApplicant(id, name);
				case "23":
					return new WorkerApplicant(id, name);
				case "25":
					return new EducationalApplicant(id, name);
				case "30":
					return new ImmigrantApplicant(id, name);
				default:
					return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
