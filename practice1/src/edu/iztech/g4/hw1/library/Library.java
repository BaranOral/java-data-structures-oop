package edu.iztech.g4.hw1.library;

import edu.iztech.g4.hw1.book.Book;

public class Library {
	private Book[] books;

	public Library(Book[] books) {
		this.books = books;
	}

	public Book getBook(String bookId) {
		for (Book book : books) {
			if (book != null && book.hasSameId(bookId)) {
				return new Book(book);
			}
		}
		return null;
	}

	public Book[] getBooks() {
		Book[] tempBooks = new Book[books.length];
		int index = 0;
		for (Book b : books) {
			if (b == null) {
				index++;
				continue;
			}
			tempBooks[index] = new Book(b);
			index++;
		}
		return tempBooks;
	}

	public Book getMostCopiedBook() {
		int copyCount = 0;
		String copiedBookId = "";
		for (Book book : books) {
			if (book != null && book.getQuantity() > copyCount) {
				copyCount = book.getQuantity();
				copiedBookId = book.getID();
			}
		}
		return getBook(copiedBookId);
	}

}
