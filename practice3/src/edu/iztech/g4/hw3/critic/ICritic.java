package edu.iztech.g4.hw3.critic;

/**
 * Interface for Critic operations
 */
public interface ICritic {

	/**
	 * Votes the Content type currentWork
	 * @return vote as double
	 */
	double vote();

	/**
	 * Work for an hour if it is occupied.
	 */
	void workOneHour();
}
