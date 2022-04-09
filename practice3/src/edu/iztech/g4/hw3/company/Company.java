package edu.iztech.g4.hw3.company;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import edu.iztech.g4.hw3.content.*;
import edu.iztech.g4.hw3.critic.*;

public class Company {
	private Queue<MovieCritic> availableMovieCritics;
	private Queue<GameCritic> availableGameCritics;
	private ArrayList<MovieCritic> workingMovieCritics;
	private ArrayList<GameCritic> workingGameCritics;
	private Stack<Movie> movieStack;
	private Stack<Game> gameStack;
	private ArrayList<RatedContent> ratedContents;
	private int day;

	public Company(Queue<MovieCritic> availableMovieCritics, Queue<GameCritic> availableGameCritics) {
		this.availableGameCritics = availableGameCritics;
		this.availableMovieCritics = availableMovieCritics;
		this.movieStack = new Stack<Movie>();
		this.gameStack = new Stack<Game>();
		this.workingMovieCritics = new ArrayList<MovieCritic>();
		this.workingGameCritics = new ArrayList<GameCritic>();
		this.ratedContents = new ArrayList<RatedContent>();
		this.day = 1;
	}

	public void runDay() {
		startMovieShift();
		System.out.printf("%d. day:\n", day);
		for (int hour = 0; hour < 8; hour++) {
			distributeGames();
			runMovies();
			runGames();
		}
		this.day += 1;
	}

	private void runMovies() {
		ArrayList<MovieCritic> tempMovieCritics = new ArrayList<MovieCritic>();
		for (MovieCritic mc : workingMovieCritics) {
			mc.workOneHour();
			if (!mc.isOccupied()) {
				Content currentWork = mc.getCurrentWork();

				RatedContent rc = new RatedContent(currentWork, mc.vote());
				ratedContents.add(rc);

				mc.setCurrentWork(null);
				availableMovieCritics.add(mc);

				System.out.printf("\t%d. movie critic evaluated (%s)\n", mc.getID(), currentWork.getName());
				continue;
			}
			tempMovieCritics.add(mc);
		}
		this.workingMovieCritics = tempMovieCritics;

	}

	private void runGames() {
		ArrayList<GameCritic> tempGameCritics = new ArrayList<GameCritic>();
		for (GameCritic gc : workingGameCritics) {
			gc.workOneHour();
			if (!gc.isOccupied()) {
				Content currentWork = gc.getCurrentWork();

				RatedContent rc = new RatedContent(currentWork, gc.vote());
				ratedContents.add(rc);

				gc.setCurrentWork(null);
				availableGameCritics.add(gc);

				System.out.printf("\t%d. game critic evaluated (%s)\n", gc.getID(), currentWork.getName());
				continue;
			}
			tempGameCritics.add(gc);
		}
		this.workingGameCritics = tempGameCritics;
	}

	private void startMovieShift() {
		while (!movieStack.isEmpty() && !availableMovieCritics.isEmpty()) {
			Movie m = movieStack.pop();
			MovieCritic mc = availableMovieCritics.poll();
			
			mc.setCurrentWork(m);
			workingMovieCritics.add(mc);
		}
	}

	private void distributeGames() {
		while (!gameStack.isEmpty() && !availableGameCritics.isEmpty()) {
			Game g = gameStack.pop();
			GameCritic gc = availableGameCritics.poll();

			gc.setCurrentWork(g);
			workingGameCritics.add(gc);

			System.out.printf("\t%d. game critic works on (%s)\n", gc.getID(), g.getName());
		}
	}

	public void addGames(Stack<Game> gameStack) {
		// We use middleware stack in here in order to preserve stack order.
		Stack<Game> tempStack = new Stack<Game>();
		while (!gameStack.isEmpty()) {
			tempStack.push(gameStack.pop());
		}
		
		while (!tempStack.isEmpty()) {
			this.gameStack.push(tempStack.pop());
		}
	}

	public void addMovies(Stack<Movie> movieStack) {
		// We use middleware stack in here in order to preserve stack order.
		Stack<Movie> tempStack = new Stack<Movie>();
		while (!movieStack.isEmpty()) {
			tempStack.push(movieStack.pop());
		}
		
		while (!tempStack.isEmpty()) {
			this.movieStack.push(tempStack.pop());
		}
	}

	public ArrayList<RatedContent> getRatedContents() {
		ArrayList<RatedContent> tempRCs = new ArrayList<RatedContent>();
		for (RatedContent rc: ratedContents ) {
			tempRCs.add(rc.clone());
		}
		return tempRCs;
	}

}
