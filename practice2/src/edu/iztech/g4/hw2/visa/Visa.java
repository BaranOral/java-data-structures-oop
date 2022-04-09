package edu.iztech.g4.hw2.visa;

import edu.iztech.g4.hw2.applicant.Applicant;

public class Visa implements Comparable<Visa> {
	private Applicant applicant;
	private Duration duration;
	private Rejection reason;

	public Visa(Applicant applicant, Duration duration, Rejection reason) {
		this.applicant = applicant.clone();
		this.duration = duration;
		this.reason = reason;
	}

	public Rejection getReason() {
		return reason;
	}

	public void setReason(Rejection reason) {
		this.reason = reason;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		String reasonText = reason == null ? "Accepted" : reason.toString();

		return applicant + ", Status: " + reasonText + duration;
	}

	@Override
	public int compareTo(Visa arg0) {
		return applicant.compareTo(arg0.applicant);
	}

}
