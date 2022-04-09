package edu.iztech.g4.hw2.applicant;

public enum EApplicant {
	TOURIST, WORKER, EDUCATIONAL, IMMIGRANT;

	@Override
	public String toString() {
		switch (this) {
			case TOURIST:
				return "Tourist";
			case WORKER:
				return "Worker";
			case EDUCATIONAL:
				return "Educational";
			case IMMIGRANT:
				return "Immigrant";
			default:
				return "NONE";
		}
	}

}
