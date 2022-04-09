package edu.iztech.g4.hw3.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import edu.iztech.g4.hw3.company.Company;
import edu.iztech.g4.hw3.critic.GameCritic;
import edu.iztech.g4.hw3.critic.MovieCritic;
import edu.iztech.g4.hw3.utils.Reader;
import edu.iztech.g4.hw3.content.*;

public class CompanyRatingSimulation {

	public static void run() {
		Queue<MovieCritic> availableMovieCritics = new LinkedList<MovieCritic>();
		availableMovieCritics.add(new MovieCritic(0.1, 1));
		availableMovieCritics.add(new MovieCritic(-0.2, 2));
		availableMovieCritics.add(new MovieCritic(0.3, 3));

		Queue<GameCritic> availableGameCritics = new LinkedList<GameCritic>();
		availableGameCritics.add(new GameCritic(5, 1));
		availableGameCritics.add(new GameCritic(9, 2));
		availableGameCritics.add(new GameCritic(-3, 3));
		availableGameCritics.add(new GameCritic(2, 4));
		availableGameCritics.add(new GameCritic(-7, 5));

		Company company = new Company(availableMovieCritics, availableGameCritics);

		for (int day = 1; day < 6; day++) {
			Stack<Game> gameStack = Reader.getGamesForADay("contents.csv", day);
			Stack<Movie> movieStack = Reader.getMoviesForADay("contents.csv", day);
			company.addGames(gameStack);
			company.addMovies(movieStack);
			company.runDay();
		}

		ArrayList<RatedContent> rcs = company.getRatedContents();
		Collections.sort(rcs, RatedContent.TYPE_NAME); // Sort by Type and Name, it uses the Comparator in RatedContent.

		System.out.println("Ratings:");
		for (RatedContent rc : rcs) {
			System.out.println("\t" + rc);
		}
	}

}
