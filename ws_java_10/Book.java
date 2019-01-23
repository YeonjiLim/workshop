package com.ssafy.edu.java;

public class Book {
	private String isbn;
	private String title;
	private int price;
	private int quantity;
	
	public Book() {}
	
	public Book(String isbn, String title, int price, int quantity) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return isbn + "|" + title+ "|" + price + "|" + quantity;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + price;
		result = prime * result + quantity;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Book b = (Book) obj;
		if(this.isbn.equals(b.getIsbn())) {
			return true;
		} else {
			return false;
		}
	}
}
