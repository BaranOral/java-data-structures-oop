package edu.iztech.g4.hw3.critic;

import edu.iztech.g4.hw3.content.Content;
import edu.iztech.g4.hw3.content.Game;

public class GameCritic extends Critic {

	public GameCritic(double opinion, int ID) {
		super(opinion, ID);
	}

	@Override
	public int startWorking(Content currentWork) {
		return (currentWork == null) ? 0 : ((Game) currentWork).play();
	}
	
	@Override
	public double vote() {
		double vote = getCurrentWork().getRateConstant() + getOpinion();
		
		return vote > 100 ? 100 : vote < 0 ? 0 : vote; // Makes sure that vote is between 100 and 0
	}

}
