package edu.iztech.g4.hw2.visa;

public enum Rejection {
	PASSPORT_NULL("Applicant does not have a passport"), PASSPORT_NOT_VALID("Passport is not valid"),
	PASSPORT_EXPIRED("Passport expiration date is not valid"), PHOTO_NULL("Applicant does not have a photo"),
	PHOTO_BAD_RESOLUTION("Resolution of photo is not valid"), PHOTO_BAD_POSITION("Position in the photo is not valid"),
	FINANCIAL_STATUS_NULL("Applicant does not have a financial status report"),
	FINANCIAL_STATUS_INSUFFICIENT("Applicant does not have a stable financial status"),
	LA_NULL("Applicant does not have a letter of acceptance");

	private final String message;

	private Rejection(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Rejected" + ", Reason: " + this.message;
	}

}
