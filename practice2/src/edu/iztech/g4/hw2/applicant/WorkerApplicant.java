package edu.iztech.g4.hw2.applicant;

import java.util.ArrayList;

import edu.iztech.g4.hw2.document.Document;
import edu.iztech.g4.hw2.document.LetterOfAcceptance;
import edu.iztech.g4.hw2.financial.FinancialStatus;
import edu.iztech.g4.hw2.passport.Passport;
import edu.iztech.g4.hw2.photo.Photo;
import edu.iztech.g4.hw2.visa.Duration;

public class WorkerApplicant extends Applicant {

	public WorkerApplicant(int applicantId, String applicantName, ArrayList<Document> documents, Photo photo,
			Passport passport, FinancialStatus financialStatus) {
		super(applicantId, applicantName, documents, photo, passport, financialStatus);
	}

	public WorkerApplicant(int applicantId, String applicantName) {
		super(applicantId, applicantName);
	}
	
	public WorkerApplicant(WorkerApplicant applicant) { // Copy Constructor
		this(applicant.getApplicantId(), applicant.getApplicantName(), applicant.getDocuments(), applicant.getPhoto(),
				applicant.getPassport(), applicant.getFinancialStatus());
	}

	@Override
	public EApplicant getType() {
		return EApplicant.WORKER;
	}

	@Override
	public FinancialStatus calculateNecessaryFinancialStatus() {
		return new FinancialStatus(this.getApplicantId(), 0, 2000);
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
		} else if (expireMonths < 60) {
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
				return Duration.FIVE_YEARS;
			}
		}
	}
	
	@Override
	public WorkerApplicant clone() {
		return new WorkerApplicant(this);
	}
}
