package edu.iztech.g4.hw2.applicant;

import java.util.ArrayList;

import edu.iztech.g4.hw2.document.Document;
import edu.iztech.g4.hw2.financial.FinancialStatus;
import edu.iztech.g4.hw2.passport.Passport;
import edu.iztech.g4.hw2.photo.Photo;
import edu.iztech.g4.hw2.visa.Duration;

public class ImmigrantApplicant extends Applicant {

	public ImmigrantApplicant(int applicantId, String applicantName, ArrayList<Document> documents, Photo photo,
			Passport passport, FinancialStatus financialStatus) {
		super(applicantId, applicantName, documents, photo, passport, financialStatus);
	}

	public ImmigrantApplicant(int applicantId, String applicantName) {
		super(applicantId, applicantName);
	}

	public ImmigrantApplicant(ImmigrantApplicant applicant) { // Copy Constructor
		this(applicant.getApplicantId(), applicant.getApplicantName(), applicant.getDocuments(), applicant.getPhoto(),
				applicant.getPassport(), applicant.getFinancialStatus());
	}

	@Override
	public EApplicant getType() {
		return EApplicant.IMMIGRANT;
	}

	@Override
	public FinancialStatus calculateNecessaryFinancialStatus() {
		boolean hasInvitation = this.hasInvitationLetter();
		int necessarySavings = 0;

		if (this.hasGreenCard()) {
			necessarySavings = 4000;
		} else {
			necessarySavings = 50000;
		}

		if (hasInvitation)
			return new FinancialStatus(this.getApplicantId(), 0, necessarySavings / 2);

		return new FinancialStatus(this.getApplicantId(), 0, necessarySavings);
	}

	@Override
	public Duration getPossibleDuration() {
		return Duration.PERMANENT;
	}

	@Override
	public ImmigrantApplicant clone() {
		return new ImmigrantApplicant(this);
	}
}
