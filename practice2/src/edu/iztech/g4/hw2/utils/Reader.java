package edu.iztech.g4.hw2.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * This utility class gets BufferedReader, and reads line by line and initializes the Array using Serializer Class.
 * The Reason all methods are static is because class does not have any instance variables.
 * And also we find unnecessary to initialize utility classes in order to use it.
 */
public class Reader {

	public static ArrayList<Object> readObject(BufferedReader bufferedReader) {
		ArrayList<Object> objects = new ArrayList<Object>();
		try {
			String line = bufferedReader.readLine();
			while (line != null) {
				if (line.startsWith(",")) {
					line = bufferedReader.readLine();
					continue;
				}
				switch (line.charAt(0)) {
					case 'A':
						objects.add(Serializer.serializeApplicant(line));
						break;
					case 'S':
						objects.add(Serializer.serializePassport(line));
						break;
					case 'P':
						objects.add(Serializer.serializePhoto(line));
						break;
					case 'F':
						objects.add(Serializer.serializeFinancialStatus(line));
						break;
					case 'D':
						objects.add(Serializer.serializeDocument(line));
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
