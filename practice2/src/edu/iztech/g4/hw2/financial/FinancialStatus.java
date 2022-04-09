package edu.iztech.g4.hw2.financial;

public class FinancialStatus {
	private final int applicantID;
	private int income;
	private int savings;

	public FinancialStatus(int applicationID, int income, int savings) {
		this.applicantID = applicationID;
		this.income = income;
		this.savings = savings;
	}

	public FinancialStatus(FinancialStatus financialStatus) { // Copy constructor
		this.applicantID = financialStatus.applicantID;
		this.income = financialStatus.income;
		this.savings = financialStatus.savings;
	}

	public int getIncome() {
		return income;
	}

	public int getSavings() {
		return savings;
	}

	public int getApplicantID() {
		return applicantID;
	}

	@Override
	public FinancialStatus clone() {
		return new FinancialStatus(this);
	}
}
