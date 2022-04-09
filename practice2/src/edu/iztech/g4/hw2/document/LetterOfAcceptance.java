package edu.iztech.g4.hw2.document;

public class LetterOfAcceptance extends Document {
	private final int durationInMonths;

	public LetterOfAcceptance(int applicantId, int durationInMonths) {
		super(applicantId);
		this.durationInMonths = durationInMonths;
	}

	public LetterOfAcceptance(LetterOfAcceptance letterOfAcceptance) {
		super(letterOfAcceptance);
		this.durationInMonths = letterOfAcceptance.durationInMonths;
	}

	@Override
	public LetterOfAcceptance clone() {
		return new LetterOfAcceptance(this);
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}
}
