package com.ssafy.edu.java;

public class Magazine extends Book {
	private int month;
	
	public Magazine() {}

	public Magazine(String isbn, String title, int price, int quantity, int month) {
		super(isbn, title, price, quantity);
		this.month = month;
	}

	@Override
	public String toString() {
		return super.toString() + "|" + month;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
