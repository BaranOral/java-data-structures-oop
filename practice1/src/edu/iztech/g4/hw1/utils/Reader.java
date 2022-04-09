package edu.iztech.g4.hw1.utils;

import java.io.BufferedReader;
import java.io.IOException;

import edu.iztech.g4.hw1.book.Book;
import edu.iztech.g4.hw1.issue.Issue;
import edu.iztech.g4.hw1.library.Library;
import edu.iztech.g4.hw1.member.Member;

/*
 * This utility class gets BufferedReader, and reads line by line and initializes the Array using Serializer Class.
 * The Reason all methods are static is because class does not have any instance variables.
 * And also we find unnecessary to initialize utility classes in order to use it.
 */
public class Reader {

	public static Issue[] readIssues(BufferedReader bufferedReader, Library library, Member[] members) {
		Issue[] issues = new Issue[30];
		try {
			String line = bufferedReader.readLine();
			int index = 0;
			while (line != null) {
				if (line.startsWith(",")) {
					line = bufferedReader.readLine();
					continue;
				}

				issues[index] = Serializer.serializeIssue(line, library, members);
				line = bufferedReader.readLine();
				index++;
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return issues;
	}

	public static Member[] readMembers(BufferedReader bufferedReader) {
		Member[] members = new Member[5];
		try {
			String line = bufferedReader.readLine();
			int index = 0;
			while (line != null) {
				if (line.startsWith("ID")) {
					line = bufferedReader.readLine();
					continue;
				}
				members[index] = Serializer.serializeMember(line);
				line = bufferedReader.readLine();
				index++;
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return members;
	}

	public static Book[] readBooks(BufferedReader bufferedReader) {
		Book[] books = new Book[20];
		try {
			String line = bufferedReader.readLine();
			int index = 0;
			while (line != null) {
				books[index] = Serializer.serializeBook(line);
				line = bufferedReader.readLine();
				index++;
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;
	}
}
