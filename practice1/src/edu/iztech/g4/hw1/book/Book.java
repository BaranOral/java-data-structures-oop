package edu.iztech.g4.hw1.book;

public class Book {
	private final String ID;
	private String title;
	private String author;
	private String publisher;
	private int edition;
	private String genre;
	private int quantity;

	public Book(String id, String title, String author, String publisher, int edition, String genre, int quantity) {
		this.ID = id;
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setEdition(edition);
		setGenre(genre);
		setQuantity(quantity);
	}

	public Book(Book book) {
		this.ID = book.ID;
		setTitle(book.title);
		setAuthor(book.author);
		setPublisher(book.publisher);
		setEdition(book.edition);
		setGenre(book.genre);
		setQuantity(book.quantity);
	}
 
	/* 
	*  We would not use setters in this situation because it has not needed anywhere else.
	*  But we wanted to use this anyway because it is part of the homework.
	*/
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public String getID() {
		return ID;
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean hasSameId(String id) {
		return this.ID.equals(id);
	}

	@Override
	public String toString() {
		return "Book [ID=" + ID + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", edition="
				+ edition + ", genre=" + genre + ", quantity=" + quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book))
			return false;
		Book book = (Book) obj;
		return ID.equals(book.ID) && title.equals(book.title) && author.equals(book.author)
				&& publisher.equals(book.publisher) && edition == book.edition && genre.equals(book.genre)
				&& quantity == book.quantity;
	}

}
