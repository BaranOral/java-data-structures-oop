package edu.iztech.g4.hw3.critic;

import edu.iztech.g4.hw3.content.Content;
import edu.iztech.g4.hw3.content.Movie;

public class MovieCritic extends Critic {

	public MovieCritic(double opinion, int ID) {
		super(opinion, ID);
	}

	@Override
	public int startWorking(Content currentWork) {
		return ((Movie) currentWork).watch();
	}
	
	@Override
	public double vote() {
		double vote = getCurrentWork().getRateConstant() + getOpinion();
		
		return vote > 10 ? 10 : vote < 0 ? 0 : vote; // Makes sure that vote is between 10 and 0
	}
}
