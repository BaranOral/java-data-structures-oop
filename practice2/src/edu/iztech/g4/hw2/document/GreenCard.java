package edu.iztech.g4.hw2.document;

public class GreenCard extends Document {

	public GreenCard(int applicantId) {
		super(applicantId);
	}

	public GreenCard(GreenCard greenCard) {
		super(greenCard);
	}

	@Override
	public GreenCard clone() {
		return new GreenCard(this);
	}
}
