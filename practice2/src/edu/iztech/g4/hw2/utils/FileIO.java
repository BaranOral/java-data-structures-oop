package edu.iztech.g4.hw2.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileIO {

	public static BufferedReader getBufferedReader(String filename) {
		BufferedReader bufferedStream = null;
		try {
			bufferedStream = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + filename + e.getMessage());
			System.exit(-1);
		}
		return bufferedStream;
	}

}
