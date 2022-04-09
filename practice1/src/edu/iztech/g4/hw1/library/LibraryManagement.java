package edu.iztech.g4.hw1.library;

import edu.iztech.g4.hw1.book.Book;
import edu.iztech.g4.hw1.issue.Issue;

public class LibraryManagement {
	private Issue[][] issuesList;

	public LibraryManagement(Issue[][] issuesList) {
		this.issuesList = issuesList;
	}

	public Issue[][] getIssuesList() {
		Issue[][] tempIssuesList = new Issue[3][30];

		int index1 = 0;
		int index2 = 0;
		for (Issue[] issues : issuesList) {
			if (issues.length < index2)
				continue;
			index2 = 0;
			for (Issue issue : issues) {
				if (issue == null) {
					index2++;
					continue;
				}
				;
				tempIssuesList[index1][index2] = new Issue(issue);
				index2++;
			}
			index1++;
		}
		return tempIssuesList;
	}

	public boolean hasIssuedBefore(Book book) {
		for (Issue[] issues : issuesList) {
			for (Issue issue : issues) {
				if (issue != null && issue.getBook().equals(book)) {
					return true;
				}
			}
		}
		return false;
	}

}
