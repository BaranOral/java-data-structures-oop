package edu.iztech.g4.hw1.app;

import edu.iztech.g4.hw1.book.Book;
import edu.iztech.g4.hw1.issue.Issue;
import edu.iztech.g4.hw1.library.Library;
import edu.iztech.g4.hw1.library.LibraryManagement;
import edu.iztech.g4.hw1.library.LibraryQuery;
import edu.iztech.g4.hw1.member.Member;
import edu.iztech.g4.hw1.utils.FileIO;
import edu.iztech.g4.hw1.utils.Reader;

public class LibraryManagementSimulation {

	
	/*
	 * This method starts simulation and initialize the necessary classes as asked in hw1.
	 */
	public static void run() {
		Book[] l1Books = Reader.readBooks(FileIO.getBufferedReader("L1_Books.csv"));
		Book[] l2Books = Reader.readBooks(FileIO.getBufferedReader("L2_Books.csv"));
		Book[] l3Books = Reader.readBooks(FileIO.getBufferedReader("L3_Books.csv"));
		Library l1 = new Library(l1Books);
		Library l2 = new Library(l2Books);
		Library l3 = new Library(l3Books);
		Member[] members = Reader.readMembers(FileIO.getBufferedReader("Members.csv"));

		Library[] libraries = { l1, l2, l3 };

		Issue[] l1Issues = Reader.readIssues(FileIO.getBufferedReader("L1_Issues.csv"), l1, members);
		Issue[] l2Issues = Reader.readIssues(FileIO.getBufferedReader("L2_Issues.csv"), l2, members);
		Issue[] l3Issues = Reader.readIssues(FileIO.getBufferedReader("L3_Issues.csv"), l3, members);

		Issue[][] allIssues = { l1Issues, l2Issues, l3Issues };
		LibraryManagement libraryManagement = new LibraryManagement(allIssues);

		LibraryQuery lq = new LibraryQuery();
		
		Book mostIssuedBook = lq.getMostIssuedBook(libraryManagement, libraries);
		Member mostIssuedMember = lq.getMostIssuedMember(libraryManagement, members);
		double highestPenalty = lq.getHighestPenalty(libraryManagement);
		Book mostCopiedBook = lq.getMostCopiedBook(libraries);
		Book leastCopiedBook = lq.getLeastCopiedBook(libraryManagement, libraries);
		Member leastIssuedMemberOnCS = lq.getLeastIssuedMemberOnCSLibrary(libraryManagement, members);

		System.out.printf("1) %s\n", mostIssuedBook.getTitle());
		System.out.printf("2) %s\n", mostIssuedMember.getName());
		System.out.printf("3) %.1f TL\n", highestPenalty);
		System.out.printf("4) %s\n", mostCopiedBook.getTitle());
		System.out.printf("5) %s\n", leastCopiedBook.getTitle());
		System.out.printf("6) %s\n", leastIssuedMemberOnCS.getName());

	}
}