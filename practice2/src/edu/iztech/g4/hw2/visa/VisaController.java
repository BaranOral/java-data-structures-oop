package edu.iztech.g4.hw2.visa;

import edu.iztech.g4.hw2.applicant.*;
import edu.iztech.g4.hw2.financial.FinancialStatus;
import edu.iztech.g4.hw2.passport.Passport;
import edu.iztech.g4.hw2.photo.Photo;

public class VisaController {

	public Visa reviewApplicant(Applicant applicant) {
		Rejection rejection = reviewApplicationInfos(applicant);
		if (rejection != null)
			return new Visa(applicant, Duration.NONE, rejection);

		Duration visaDuration = calculateVisa(applicant);
		if (visaDuration.equals(Duration.NONE)) {
			if (applicant instanceof EducationalApplicant || applicant instanceof WorkerApplicant)
				rejection = Rejection.PASSPORT_EXPIRED;
			else if (applicant instanceof TouristApplicant)
				rejection = Rejection.FINANCIAL_STATUS_INSUFFICIENT;
		}

		return new Visa(applicant, visaDuration, rejection);
	}

	private Duration calculateVisa(Applicant applicant) {
		return applicant.getPossibleDuration();
	}

	private Rejection reviewApplicationInfos(Applicant applicant) {
		Rejection r;
		r = reviewPassport(applicant);
		if (r != null)
			return r;
		r = reviewPhoto(applicant);
		if (r != null)
			return r;
		r = reviewFinancialStatus(applicant);
		if (r != null)
			return r;
		r = reviewDocuments(applicant);
		if (r != null)
			return r;
		return null;
	}

	private Rejection reviewPassport(Applicant applicant) {
		Passport tempPassport = applicant.getPassport();
		if (tempPassport == null) {
			return Rejection.PASSPORT_NULL;
		}
		return tempPassport.checkValidity();
	}

	private Rejection reviewPhoto(Applicant applicant) {
		Photo tempPhoto = applicant.getPhoto();
		if (tempPhoto == null) {
			return Rejection.PHOTO_NULL;
		}
		return tempPhoto.checkValidity();
	}

	private Rejection reviewFinancialStatus(Applicant applicant) {
		FinancialStatus fStatus = applicant.getFinancialStatus();
		if (fStatus == null) {
			return Rejection.FINANCIAL_STATUS_NULL;
		}

		FinancialStatus nStatus = applicant.calculateNecessaryFinancialStatus();

		if (fStatus.getIncome() < nStatus.getIncome() || fStatus.getSavings() < nStatus.getSavings()) {
			return Rejection.FINANCIAL_STATUS_INSUFFICIENT;
		}
		return null;
	}

	private Rejection reviewDocuments(Applicant applicant) {
		switch (applicant.getType()) {
			case WORKER:
			case EDUCATIONAL:
				if (!applicant.hasLetterOfAcceptance())
					return Rejection.LA_NULL;
				break;
			default:
				return null;
		}
		return null;
	}

}
