package edu.iztech.g4.hw2.visa;

/**
 * Validator Interface for checking necessities for a Visa
 */
public interface IValidator {

	/**
	 * Check validity of the Object,
	 * @return Rejection Enum on invalid or null on valid
	 */
	Rejection checkValidity();

}
