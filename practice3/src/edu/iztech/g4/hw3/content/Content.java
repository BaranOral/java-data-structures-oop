package edu.iztech.g4.hw3.content;

public abstract class Content implements IRateable {
	private String name;
	private double averageRating;

	public Content(String name, double averageRating) {
		this.name = name;
		this.averageRating = averageRating;
	}

	@Override
	public String toString() {
		return String.format("%s", name);
	}
	
	@Override
	public abstract Content clone();
	
	public String getName() {
		return name;
	}

	public double getAverageRating() {
		return averageRating;
	}
}
