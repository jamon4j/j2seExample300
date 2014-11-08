package j2seExample300.Chapter6OOP1;

public class Book {
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(String bookName, String writer, double price) {
		super();
		this.bookName = bookName;
		this.writer = writer;
		this.price = price;
	}
	private String bookName;
	private String writer;
	private double price;
}
