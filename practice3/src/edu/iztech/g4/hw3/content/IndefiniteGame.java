package edu.iztech.g4.hw3.content;

public class IndefiniteGame extends Game {
	private int minimumEvalTime;

	public IndefiniteGame(String name, double averageRating, int minimumEvalTime) {
		super(name, averageRating);
		this.minimumEvalTime = minimumEvalTime;
	}
	
	public IndefiniteGame(IndefiniteGame indefiniteGame) {
		this(indefiniteGame.getName(), indefiniteGame.getAverageRating(), indefiniteGame.minimumEvalTime);
	}

	@Override
	public double getRateConstant() {
		return super.getAverageRating() + ((10 - minimumEvalTime) * 0.25);
	}

	@Override
	public int play() {
		return 4;
	}

	@Override
	public IndefiniteGame clone() {
		return new IndefiniteGame(this);
	}

}
