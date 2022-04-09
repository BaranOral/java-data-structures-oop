package edu.iztech.g4.hw2.passport;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import edu.iztech.g4.hw2.utils.StringUtils;
import edu.iztech.g4.hw2.visa.IValidator;
import edu.iztech.g4.hw2.visa.Rejection;

public class Passport implements IValidator {
	private final int applicantID;
	private final String passportNumber;
	private final Date expirationDate;

	public Passport(int applicantID, String passportNumber, Date expirationDate) {
		this.applicantID = applicantID;
		this.passportNumber = passportNumber;
		this.expirationDate = expirationDate;
	}

	public Passport(Passport passport) { // Copy constructor
		this.applicantID = passport.applicantID;
		this.passportNumber = passport.passportNumber;
		this.expirationDate = new Date(passport.expirationDate.getTime());
	}

	/*
	 * Passport number should have 10 characters, it should start with P, Last three
	 * characters should be digits (e.g., P34AST9G587) and Expiration date should be
	 * at least 6 months later.
	 */
	@Override
	public Rejection checkValidity() {
		if (!isNumberValid()) {
			return (Rejection.PASSPORT_NOT_VALID);
		}
		if (isExpired()) {
			return Rejection.PASSPORT_EXPIRED;
		}
		return null;
	}

	public int getRemainingMonth() {
		return getExpirationAsDay() / 30;
	}

	private boolean isExpired() {
		return getExpirationAsDay() < 183;
	}
	
	private int getExpirationAsDay() {
		Date now = new Date(System.currentTimeMillis());
		long diffInMillies = expirationDate.getTime() - now.getTime();
		
		return (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	private boolean isNumberValid() {
		return passportNumber.length() == 10 && passportNumber.startsWith("P")
				&& StringUtils.isNumeric(passportNumber.substring(passportNumber.length() - 3));
	}

	public int getApplicantID() {
		return applicantID;
	}

	@Override
	public Passport clone() {
		return new Passport(this);
	}

}