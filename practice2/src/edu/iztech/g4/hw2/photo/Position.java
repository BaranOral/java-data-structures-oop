package edu.iztech.g4.hw2.photo;

public enum Position {
	NEUTRAL_FACE, NATURAL_SMILE;

	@Override
	public String toString() {
		switch (this) {
			case NEUTRAL_FACE:
				return "Neutral Face";
			case NATURAL_SMILE:
				return "Natural Smile";
			default:
				return "None";
		}
	}
}
