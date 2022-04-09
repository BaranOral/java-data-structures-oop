package edu.iztech.g4.hw2.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import edu.iztech.g4.hw2.applicant.*;
import edu.iztech.g4.hw2.document.*;
import edu.iztech.g4.hw2.financial.FinancialStatus;
import edu.iztech.g4.hw2.passport.Passport;
import edu.iztech.g4.hw2.photo.Photo;
import edu.iztech.g4.hw2.utils.FileIO;
import edu.iztech.g4.hw2.utils.Reader;
import edu.iztech.g4.hw2.visa.Visa;
import edu.iztech.g4.hw2.visa.VisaController;

public class VisaControlSimulation {

	/*
	 * This method starts simulation and initialize the necessary classes as asked
	 * in hw2.
	 */
	public static void run() {
		ArrayList<Object> objects = Reader.readObject(FileIO.getBufferedReader("HW2_ApplicantsInfo.csv"));

		ArrayList<Photo> photos = new ArrayList<Photo>();
		ArrayList<Passport> passports = new ArrayList<Passport>();
		ArrayList<Applicant> applicants = new ArrayList<Applicant>();
		ArrayList<Document> documents = new ArrayList<Document>();
		ArrayList<FinancialStatus> financialStatuss = new ArrayList<FinancialStatus>();

		for (Object obj : objects) {
			if (obj instanceof Photo) {
				photos.add((Photo) obj);
			} else if (obj instanceof Passport) {
				passports.add((Passport) obj);
			} else if (obj instanceof Applicant) {
				applicants.add((Applicant) obj);
			} else if (obj instanceof Document) {
				documents.add((Document) obj);
			} else if (obj instanceof FinancialStatus) {
				financialStatuss.add((FinancialStatus) obj);
			}
		}

		for (Applicant applicant : applicants) {
			applicant.setPhoto(photos.stream().filter(p -> p.getApplicantID() == applicant.getApplicantId()).findAny()
					.orElse(null));
			applicant.setPassport(passports.stream().filter(p -> p.getApplicantID() == applicant.getApplicantId())
					.findAny().orElse(null));
			applicant.setFinancialStatus(financialStatuss.stream()
					.filter(f -> f.getApplicantID() == applicant.getApplicantId()).findAny().orElse(null));

			ArrayList<Document> applicantDocuments = (ArrayList<Document>) documents.stream() // Filtering documents by their applicantId
					.filter(d -> d.getApplicantId() == applicant.getApplicantId()).collect(Collectors.toList());

			applicant.setDocuments(applicantDocuments);
		}

		VisaController Embassy = new VisaController();

		ArrayList<Visa> visas = new ArrayList<Visa>();
		for (Applicant app : applicants) {
			visas.add(Embassy.reviewApplicant(app));
		}

		Collections.sort(visas); // This is for sorting visas, as mentioned in the document
		for (Visa visa : visas) {
			System.out.println(visa);
		}
	}
}