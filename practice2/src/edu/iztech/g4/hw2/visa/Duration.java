package edu.iztech.g4.hw2.visa;

public enum Duration {
	SIX_MONTHS("6 Months"), ONE_YEAR("1 Year"), TWO_YEARS("2 Years"), FOUR_YEARS("4 Years"), FIVE_YEARS("5 Years"),
	PERMANENT("Permanent"), NONE("None");

	private final String message;

	private Duration(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this != Duration.NONE ? ", Visa Duration: " + message : "";
	}

}
