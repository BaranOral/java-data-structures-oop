package edu.iztech.g4.hw1.library;

import edu.iztech.g4.hw1.book.Book;
import edu.iztech.g4.hw1.issue.Issue;
import edu.iztech.g4.hw1.member.Member;

public class LibraryQuery {

	public Book getMostIssuedBook(LibraryManagement libraryManagement, Library[] libraries) {
		Issue[][] issuesList = libraryManagement.getIssuesList();

		if (issuesList.length != libraries.length)
			return null;

		int mostIssuedLibraryIndex = 0;
		int mostIssuedBookCount = 0;
		String mostIssuedBookId = "";
		for (int i = 0; i < libraries.length; i++) {
			for (Book book : libraries[i].getBooks()) {
				if (book == null)
					continue;
				int issueNumber = 0;
				String bookId = book.getID();
				for (Issue issue : issuesList[i]) {
					if (issue != null && issue.getBook().hasSameId(bookId)) {
						issueNumber++;
					}
				}
				if (issueNumber > mostIssuedBookCount) {
					mostIssuedBookCount = issueNumber;
					mostIssuedBookId = bookId;
					mostIssuedLibraryIndex = i;
				}
			}
		}

		return libraries[mostIssuedLibraryIndex].getBook(mostIssuedBookId);
	}

	public Member getMostIssuedMember(LibraryManagement libraryManagement, Member[] members) {
		Issue[][] issuesList = libraryManagement.getIssuesList();

		int mostIssuedMemberId = 0, mostIssuedMemberCount = 0;
		for (Member member : members) {
			if (member.getName().equals("admin"))
				continue;
			int memberId = member.getID();
			int issueNumber = 0;
			for (int i = 0; i < issuesList.length; i++) {
				for (Issue issue : issuesList[i]) {
					if (issue != null && issue.getMember().hasSameId(memberId)) {
						issueNumber++;
					}
				}
			}
			if (issueNumber > mostIssuedMemberCount) {
				mostIssuedMemberCount = issueNumber;
				mostIssuedMemberId = memberId;
			}

		}

		for (Member member : members) {
			if (member.hasSameId(mostIssuedMemberId))
				return member;
		}
		return null;
	}

	public double getHighestPenalty(LibraryManagement libraryManagement) {
		Issue[][] issuesList = libraryManagement.getIssuesList();

		double highestPenalty = 0.0;
		for (Issue[] issues : issuesList) {
			for (Issue issue : issues) {
				if (issue != null && issue.getPenalty() > highestPenalty)
					highestPenalty = issue.getPenalty();
			}
		}
		return highestPenalty;
	}

	public Book getMostCopiedBook(Library[] libraries) {
		int mostCopyCount = 0;
		int mostCopyBookIndex = 0;

		for (int i = 0; i < libraries.length; i++) {
			int quantity = libraries[i].getMostCopiedBook().getQuantity();
			if (quantity > mostCopyCount) {
				mostCopyCount = quantity;
				mostCopyBookIndex = i;
			}
		}

		return libraries[mostCopyBookIndex].getMostCopiedBook();
	}

	public Book getLeastCopiedBook(LibraryManagement libraryManagement, Library[] libraries) {
		int leastCopyCount = Integer.MAX_VALUE;
		int leastCopyBookIndex = 0;

		for (int i = 0; i < libraries.length; i++) {
			int quantity = getLeastCopiedIssuedBook(libraries[i], libraryManagement).getQuantity();
			if (quantity > leastCopyCount) {
				leastCopyCount = quantity;
				leastCopyBookIndex = i;
			}
		}

		return getLeastCopiedIssuedBook(libraries[leastCopyBookIndex], libraryManagement);
	}

	private Book getLeastCopiedIssuedBook(Library library, LibraryManagement libraryManagement) {
		Book[] books = library.getBooks();
		int copyCount = Integer.MAX_VALUE;
		String copiedBookId = "";
		for (Book book : books) {
			if (book != null && libraryManagement.hasIssuedBefore(book) && book.getQuantity() < copyCount) {
				copyCount = book.getQuantity();
				copiedBookId = book.getID();
			}
		}

		return library.getBook(copiedBookId);
	}

	public Member getLeastIssuedMemberOnCSLibrary(LibraryManagement libraryManagement, Member[] members) {
		Issue[] issues = libraryManagement.getIssuesList()[2];

		int leastIssuedMemberId = 0, leastIssuedMemberCount = Integer.MAX_VALUE;
		for (Member member : members) {
			if (member.getName().equals("admin"))
				continue;
			int memberId = member.getID();
			int issueNumber = 0;
			for (Issue issue : issues) {
				if (issue != null && issue.getMember().hasSameId(memberId)) {
					issueNumber++;
				}
			}
			if (issueNumber < leastIssuedMemberCount) {
				leastIssuedMemberCount = issueNumber;
				leastIssuedMemberId = memberId;
			}

		}

		for (Member member : members) {
			if (member.hasSameId(leastIssuedMemberId))
				return member;
		}
		return null;

	}

}
