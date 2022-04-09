package edu.iztech.g4.hw3.content;

public class StoryGame extends Game {
	private int storyDuration;

	public StoryGame(String name, double averageRating, int storyDuration) {
		super(name, averageRating);
		this.storyDuration = storyDuration;
	}
	
	public StoryGame(StoryGame storyGame) {
		this(storyGame.getName(), storyGame.getAverageRating(), storyGame.storyDuration);
	}

	@Override
	public double getRateConstant() {
		return super.getAverageRating() + (storyDuration * 0.25);
	}

	@Override
	public int play() {
		return storyDuration;
	}

	@Override
	public StoryGame clone() {
		return new StoryGame(this);
	}
}
