package edu.iztech.g4.hw3.content;

public class CasualGame extends Game {
	private int matchDuration;

	public CasualGame(String name, double averageRating, int matchDuration) {
		super(name, averageRating);
		this.matchDuration = matchDuration;
	}

	public CasualGame(CasualGame casualGame) {
		this(casualGame.getName(), casualGame.getAverageRating(), casualGame.matchDuration);
	}

	@Override
	public double getRateConstant() {
		return super.getAverageRating() + ((matchDuration - 3) * 3);
	}

	@Override
	public int play() {
		return matchDuration * 3;
	}

	@Override
	public CasualGame clone() {
		return new CasualGame(this);
	}

}
