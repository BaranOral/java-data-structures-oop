/**
 * 
 */
package edu.iztech.g4.hw4.customer;

/**
 *
 */
public interface ICustomer<T> {

	boolean isMember();

	int calculateDiscount();

	T getCustomerId();

}
