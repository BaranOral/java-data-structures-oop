package edu.iztech.g4.hw2.applicant;

import java.util.ArrayList;

import edu.iztech.g4.hw2.document.Document;
import edu.iztech.g4.hw2.document.LetterOfAcceptance;
import edu.iztech.g4.hw2.financial.FinancialStatus;
import edu.iztech.g4.hw2.passport.Passport;
import edu.iztech.g4.hw2.photo.Photo;
import edu.iztech.g4.hw2.visa.Duration;

public class EducationalApplicant extends Applicant {

	public EducationalApplicant(int applicantId, String applicantName, ArrayList<Document> documents, Photo photo,
			Passport passport, FinancialStatus financialStatus) {
		super(applicantId, applicantName, documents, photo, passport, financialStatus);
	}

	public EducationalApplicant(int applicantId, String applicantName) {
		super(applicantId, applicantName);
	}

	public EducationalApplicant(EducationalApplicant applicant) { // Copy Constructor
		this(applicant.getApplicantId(), applicant.getApplicantName(), applicant.getDocuments(), applicant.getPhoto(),
				applicant.getPassport(), applicant.getFinancialStatus());
	}

	@Override
	public EApplicant getType() {
		return EApplicant.EDUCATIONAL;
	}

	@Override
	public FinancialStatus calculateNecessaryFinancialStatus() {
		int necessarySavings = 0;
		boolean hasInvitation = this.hasInvitationLetter();

		int appIncome = this.getFinancialStatus().getIncome();
		if (appIncome < 1000) {
			necessarySavings = Integer.MAX_VALUE; // Because it is not possible to have
		} else if (appIncome >= 1000 && appIncome < 2000) {
			necessarySavings = 6000;
		} else if (appIncome >= 2000 && appIncome <= 3000) {
			necessarySavings = 3000;
		} else {
			necessarySavings = 0;
		}

		if (hasInvitation)
			return new FinancialStatus(this.getApplicantId(), 500, necessarySavings / 2);

		return new FinancialStatus(this.getApplicantId(), 1000, necessarySavings);
	}

	@Override
	public Duration getPossibleDuration() {
		int expireMonths = this.getPassport().getRemainingMonth();
		LetterOfAcceptance k = (LetterOfAcceptance) this.getDocuments().stream()
				.filter(d -> d instanceof LetterOfAcceptance).findFirst().orElse(null);

		int laDuration = k.getDurationInMonths();

		if (expireMonths < 12) {
			return Duration.NONE;
		} else if (expireMonths < 24) {
			return Duration.ONE_YEAR;
		} else if (expireMonths < 48) {
			if (laDuration < 12) {
				return Duration.ONE_YEAR;
			} else {
				return Duration.TWO_YEARS;
			}
		} else {
			if (laDuration < 12) {
				return Duration.ONE_YEAR;
			} else if (laDuration < 24) {
				return Duration.TWO_YEARS;
			} else {
				return Duration.FOUR_YEARS;
			}
		}
	}

	@Override
	public EducationalApplicant clone() {
		return new EducationalApplicant(this);
	}
}
