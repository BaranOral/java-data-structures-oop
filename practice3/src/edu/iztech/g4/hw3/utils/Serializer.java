package edu.iztech.g4.hw3.utils;

import java.util.StringTokenizer;

import edu.iztech.g4.hw3.content.*;

/**
 * This utility class gets String line from Reader, and tokenizes and return class using StringTokenizer.
 * Reason all methods are static is, class does not have any instance variables.
 * And also we find unnecessary to initialize utility classes in order to use it.
 */
public class Serializer {

	public static Movie serializeMovie(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		Movie tempMovie = null;
		try {
			st.nextToken();
			st.nextToken();

			String name = st.nextToken();
			int year = Integer.parseInt(st.nextToken());
			int duration = Integer.parseInt(st.nextToken());
			double averageRating = Double.parseDouble(st.nextToken());

			tempMovie = new Movie(name, averageRating, year, duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempMovie;
	}

	public static IndefiniteGame serializeIndefiniteGame(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		IndefiniteGame tempIndefiniteGame = null;
		try {
			st.nextToken();
			st.nextToken();

			String name = st.nextToken();
			int minimumEvalTime = Integer.parseInt(st.nextToken());
			double averageRating = Double.parseDouble(st.nextToken());

			tempIndefiniteGame = new IndefiniteGame(name, averageRating, minimumEvalTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempIndefiniteGame;
	}

	public static StoryGame serializeStoryGame(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		StoryGame tempStoryGame = null;
		try {
			st.nextToken();
			st.nextToken();

			String name = st.nextToken();
			int storyDuration = Integer.parseInt(st.nextToken());
			double averageRating = Double.parseDouble(st.nextToken());

			tempStoryGame = new StoryGame(name, averageRating, storyDuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempStoryGame;
	}

	public static CasualGame serializeCasualGame(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		CasualGame tempCasualGame = null;
		try {
			st.nextToken();
			st.nextToken();

			String name = st.nextToken();
			int matchDuration = Integer.parseInt(st.nextToken());
			double averageRating = Double.parseDouble(st.nextToken());

			tempCasualGame = new CasualGame(name, averageRating, matchDuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempCasualGame;
	}
}
