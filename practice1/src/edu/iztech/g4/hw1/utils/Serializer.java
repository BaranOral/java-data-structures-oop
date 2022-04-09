package edu.iztech.g4.hw1.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import edu.iztech.g4.hw1.book.Book;
import edu.iztech.g4.hw1.issue.Issue;
import edu.iztech.g4.hw1.library.Library;
import edu.iztech.g4.hw1.member.Member;

/*
 * This utility class gets String line from Reader, and tokenizes and return class using StringTokenizer.
 * Reason all methods are static is, class does not have any instance variables.
 * And also we find unnecessary to initialize utility classes in order to use it.
 */
public class Serializer {

	public static Issue serializeIssue(String line, Library library, Member[] members) {
		StringTokenizer st = new StringTokenizer(line, ",");
		Issue tempIssue = null;
		try {
			if (st.countTokens() < 5)
				return null;
			int id = Integer.parseInt(st.nextToken());

			int memberId = Integer.parseInt(st.nextToken());
			Member member = null;
			for (Member tempMember : members) {
				if (tempMember != null && tempMember.hasSameId(memberId)) {
					member = new Member(tempMember);
				}
				;
			}

			String bookId = st.nextToken();
			Book book = library.getBook(bookId);

			/*
			 * According to: https://docs.oracle.com/javase/7/docs/api/java/util/Date.html
			 * Initializing Date using String is deprecated since Java 7. So I used
			 * DateFormat Class in java.text as suggested in the doc.
			 */
			DateFormat parser = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);

			String issueString = st.nextToken();
			Date issueDate = parser.parse(issueString);

			String returningString = st.nextToken();
			Date returningDate = parser.parse(returningString);

			tempIssue = new Issue(id, member, book, issueDate, returningDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempIssue;
	}

	public static Member serializeMember(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		Member tempMember = null;
		try {
			if (st.countTokens() < 3)
				return null;

			int id = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			String email = st.nextToken();

			tempMember = new Member(id, name, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempMember;
	}

	public static Book serializeBook(String line) {
		StringTokenizer st = new StringTokenizer(line, ",");
		Book tempBook = null;
		try {
			if (st.countTokens() < 7)
				return null;

			String id = st.nextToken();
			String title = st.nextToken();
			String author = st.nextToken();
			String publisher = st.nextToken();

			int edition = Integer.parseInt(st.nextToken());
			String genre = st.nextToken();
			int quantity = Integer.parseInt(st.nextToken());

			tempBook = new Book(id, title, author, publisher, edition, genre, quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempBook;
	}
}
