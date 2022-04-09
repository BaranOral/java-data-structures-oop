package edu.iztech.g4.hw2.applicant;

import edu.iztech.g4.hw2.financial.FinancialStatus;
import edu.iztech.g4.hw2.visa.Duration;

/**
 * Interface for checking applicant's documents
 */
public interface IApplicant {
	/**
	 * @return Applicant type as EApplicant Enum
	 */
	EApplicant getType(); // Add javadoc

	/**
	 * @return Visa duration as Duration Enum
	 */
	Duration getPossibleDuration();

	/**
	 * Calculates necessary financial status for applicant
	 * @return Necessary Financial Status
	 */
	FinancialStatus calculateNecessaryFinancialStatus();

	/**
	 * Checks if applicant has Letter Of Acceptance
	 */
	boolean hasLetterOfAcceptance();

	/**
	 * Checks if applicant has Invitation Letter
	 */
	boolean hasInvitationLetter();

	/**
	 * Checks if applicant has Green Card
	 */
	boolean hasGreenCard();
}
