package edu.iztech.g4.hw3.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import edu.iztech.g4.hw3.content.Content;
import edu.iztech.g4.hw3.content.Game;
import edu.iztech.g4.hw3.content.Movie;

/**
 * This utility class gets BufferedReader, and reads line by line and initializes the Array using Serializer Class.
 * The Reason all methods are static is because class does not have any instance variables.
 * And also we find unnecessary to initialize utility classes in order to use it.
 */
public class Reader {

	public static Stack<Game> getGamesForADay(String filename, int day) {
		ArrayList<Content> contents = readContentAtDay(FileIO.getBufferedReader(filename), day);
		Stack<Game> gameStack = new Stack<Game>();
		for (Content content : contents) {
			if (content instanceof Game) {
				gameStack.push((Game) content);
			}
		}
		return gameStack;
	}

	public static Stack<Movie> getMoviesForADay(String filename, int day) {
		ArrayList<Content> contents = readContentAtDay(FileIO.getBufferedReader(filename), day);
		Stack<Movie> movieStack = new Stack<Movie>();
		for (Content content : contents) {
			if (content instanceof Movie) {
				movieStack.push((Movie) content);
			}
		}
		return movieStack;
	}

	private static ArrayList<Content> readContentAtDay(BufferedReader bufferedReader, int day) {
		ArrayList<Content> objects = new ArrayList<Content>();
		try {
			String line = bufferedReader.readLine();
			while (line != null) {
				if (!line.startsWith(String.valueOf(day))) {
					line = bufferedReader.readLine();
					continue;
				}
				switch (line.charAt(2)) {
					case '0':
						objects.add(Serializer.serializeMovie(line));
						break;
					case '1':
						objects.add(Serializer.serializeIndefiniteGame(line));
						break;
					case '2':
						objects.add(Serializer.serializeStoryGame(line));
						break;
					case '3':
						objects.add(Serializer.serializeCasualGame(line));
						break;
					default:
						break;
				}
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objects;
	}
}
