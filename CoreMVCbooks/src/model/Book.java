package model;

public class Book {
	
	private int bcode;
	private String btitle;
	private String author;
	private String subject;
	private int price;
	
	public Book(int bcode, String btitle, String author, String subject, int price) {
		super();
		this.bcode = bcode;
		this.btitle = btitle;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}
	
	public Book() {}

	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bcode=" + bcode + ", btitle=" + btitle + ", author=" + author + ", subject=" + subject
				+ ", price=" + price + "]";
	}
	
	
	
	

}

