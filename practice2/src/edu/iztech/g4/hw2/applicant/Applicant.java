package edu.iztech.g4.hw2.applicant;

import java.util.ArrayList;

import edu.iztech.g4.hw2.document.*;
import edu.iztech.g4.hw2.financial.*;
import edu.iztech.g4.hw2.passport.*;
import edu.iztech.g4.hw2.photo.*;
import edu.iztech.g4.hw2.visa.*;

public abstract class Applicant implements Comparable<Applicant>, IApplicant {
	private final int applicantId;
	private final String applicantName;
	private ArrayList<Document> documents;
	private Photo photo;
	private Passport passport;
	private FinancialStatus financialStatus;

	public Applicant(int applicantId, String applicantName, ArrayList<Document> documents, Photo photo,
			Passport passport, FinancialStatus financialStatus) { // Full argument constructor
		this.applicantId = applicantId;
		this.applicantName = applicantName;
		setDocuments(documents);
		setPhoto(photo);
		setPassport(passport);
		setFinancialStatus(financialStatus);
	}

	public Applicant(int applicantId, String applicantName) {
		this.applicantId = applicantId;
		this.applicantName = applicantName;
	}

	public Applicant(Applicant applicant) { // Copy Constructor
		this(applicant.applicantId, applicant.applicantName, applicant.documents, applicant.photo, applicant.passport,
				applicant.financialStatus);
	}

	public abstract EApplicant getType();

	public abstract Duration getPossibleDuration();

	public abstract FinancialStatus calculateNecessaryFinancialStatus();

	public boolean hasLetterOfAcceptance() {
		for (Document document : documents) {
			if (document instanceof LetterOfAcceptance)
				return true;
		}
		return false;
	}

	public boolean hasInvitationLetter() {
		for (Document document : documents) {
			if (document instanceof InvitationLetter)
				return true;
		}
		return false;
	}

	public boolean hasGreenCard() {
		for (Document document : documents) {
			if (document instanceof GreenCard)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Applicant ID: " + this.getApplicantId() + ", Name: " + this.getApplicantName() + ", Visa Type: "
				+ getType();
	}

	@Override
	public int compareTo(Applicant arg0) {
		if (applicantId > arg0.applicantId) {
			return 1;
		} else if (applicantId < arg0.applicantId) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public abstract Applicant clone();

	public void setDocuments(ArrayList<Document> documents) { // Doing deep copy to prevent privacy leaks
		if (documents == null)
			this.documents = null;
		else {
			ArrayList<Document> copiedDocuments = new ArrayList<>();
			for (Document d : documents) {
				copiedDocuments.add(d.clone());
			}
			this.documents = copiedDocuments;
		}
	}

	public void setPhoto(Photo photo) {
		if (photo == null)
			this.photo = null;
		else
			this.photo = photo.clone();
	}

	public void setPassport(Passport passport) {
		if (passport == null)
			this.passport = null;
		else
			this.passport = passport.clone();
	}

	public void setFinancialStatus(FinancialStatus financialStatus) {
		if (financialStatus == null)
			this.financialStatus = null;
		else
			this.financialStatus = financialStatus.clone();
	}

	public int getApplicantId() {
		return applicantId;
	}

	public Photo getPhoto() {
		if (photo == null)
			return null;
		return photo.clone();
	}

	public Passport getPassport() {
		if (passport == null)
			return null;
		return passport.clone();
	}

	public FinancialStatus getFinancialStatus() {
		if (financialStatus == null)
			return null;
		return financialStatus.clone();
	}

	public ArrayList<Document> getDocuments() { // Doing deep copy to prevent privacy leaks
		if (documents == null)
			return null;
		ArrayList<Document> copiedDocuments = new ArrayList<>();
		for (Document d : documents) {
			copiedDocuments.add(d.clone());
		}
		return copiedDocuments;
	}

	public String getApplicantName() {
		return applicantName;
	}
}