package edu.iztech.g4.hw3.content;

public abstract class Game extends Content {

	public Game(String name, double averageRating) {
		super(name, averageRating);
	}

	public abstract int play();

}
