package edu.iztech.g4.hw3.content;

public class Movie extends Content {
	private int year;
	private int duration; // Stored in minutes
	
	public Movie(String name, double averageRating, int year, int duration) {
		super(name, averageRating);
		this.year = year;
		this.duration = duration;
	}

	public Movie(Movie movie) {
		this(movie.getName(), movie.getAverageRating(), movie.year, movie.duration);
	}

	public int watch() {
		return duration / 60;
	}

	@Override
	public double getRateConstant() {
		return super.getAverageRating() + ((duration - 150) * 0.01) - ((2021 - year) * 0.01);
	}

	@Override
	public String toString() {
		return String.format("%s (%d)", super.getName(), year);
	}

	@Override
	public Movie clone() {
		return new Movie(this);
	}
}
