package edu.iztech.g4.hw2.applicant;

import java.util.ArrayList;

import edu.iztech.g4.hw2.document.*;
import edu.iztech.g4.hw2.financial.FinancialStatus;
import edu.iztech.g4.hw2.passport.Passport;
import edu.iztech.g4.hw2.photo.Photo;
import edu.iztech.g4.hw2.visa.Duration;

public class TouristApplicant extends Applicant {

	public TouristApplicant(int applicantId, String applicantName, ArrayList<Document> documents, Photo photo,
			Passport passport, FinancialStatus financialStatus) {
		super(applicantId, applicantName, documents, photo, passport, financialStatus);
	}

	public TouristApplicant(int applicantId, String applicantName) {
		super(applicantId, applicantName);
	}

	public TouristApplicant(TouristApplicant applicant) { // Copy Constructor
		this(applicant.getApplicantId(), applicant.getApplicantName(), applicant.getDocuments(), applicant.getPhoto(),
				applicant.getPassport(), applicant.getFinancialStatus());
	}

	@Override
	public EApplicant getType() {
		return EApplicant.TOURIST;
	}

	@Override
	public FinancialStatus calculateNecessaryFinancialStatus() {
		int necessarySavings = 0;
		boolean hasInvitation = this.hasInvitationLetter();

		int appIncome = this.getFinancialStatus().getIncome();
		if (appIncome < 2000) {
			necessarySavings = Integer.MAX_VALUE; // Because it is not possible to have
		} else if (appIncome >= 2000 && appIncome < 3000) {
			necessarySavings = 12000;
		} else if (appIncome >= 3000 && appIncome <= 4000) {
			necessarySavings = 6000;
		} else {
			necessarySavings = 0;
		}

		if (hasInvitation)
			return new FinancialStatus(this.getApplicantId(), 1000, necessarySavings / 2);

		return new FinancialStatus(this.getApplicantId(), 2000, necessarySavings);
	}

	@Override
	public Duration getPossibleDuration() {
		FinancialStatus stat = this.getFinancialStatus();
		int income = stat.getIncome();
		int savings = stat.getSavings();

		double DC = (((income - 2000) * 6) + savings) / 12000.0;

		if (this.hasInvitationLetter()) {
			DC *= 2;
		}

		if (DC < 1) {
			return Duration.NONE;
		} else if (DC < 2) {
			return Duration.SIX_MONTHS;
		} else if (DC < 4) {
			return Duration.ONE_YEAR;
		} else {
			return Duration.FIVE_YEARS;
		}
	}
	
	@Override
	public TouristApplicant clone() {
		return new TouristApplicant(this);
	}
}
