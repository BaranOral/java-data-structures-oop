package edu.iztech.g4.hw1.issue;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import edu.iztech.g4.hw1.book.Book;
import edu.iztech.g4.hw1.member.Member;

public class Issue {
	private final int ID;
	private Member member;
	private Book book;
	private Date issueDate;
	private Date returningDate;

	public Issue(int id, Member member, Book book, Date issueDate, Date returningDate) {
		this.ID = id;
		this.member = member;
		this.book = book;
		this.issueDate = issueDate;
		this.returningDate = returningDate;
	}

	public Issue(Issue issue) {
		this.ID = issue.ID;
		this.member = new Member(issue.member);
		this.book = new Book(issue.book);
		this.issueDate = new Date(issue.issueDate.getTime());
		this.returningDate = new Date(issue.returningDate.getTime());
	}

	public Member getMember() {
		return new Member(member);
	}

	public Book getBook() {
		return new Book(book);
	}

	public double getPenalty() {
		long diff = returningDate.getTime() - issueDate.getTime();

		// I used TimeUnit for measuring days between dates.
		long lateDays = TimeUnit.DAYS.convert(diff, TimeUnit.DAYS) / (1000 * 60 * 60 * 24);
		return lateDays > 14 ? (lateDays - 14) * 0.5 : 0.0;
	}

	@Override
	public String toString() {
		return "Issue [ID=" + ID + ", member=" + member + ", book=" + book + ", issueDate=" + issueDate
				+ ", returningDate=" + returningDate + "]";
	}

}
