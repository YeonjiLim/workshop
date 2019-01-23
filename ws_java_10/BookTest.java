package com.ssafy.edu.java;

import java.util.ArrayList;

public class BookTest {
	public static void main(String[] args) {
		BookMgrImpl bookMgrImpl = BookMgrImpl.getInstance();
		bookMgrImpl.open();
		ArrayList<Book> books = (ArrayList<Book>) bookMgrImpl.search();
		for(Book b:books) {
			System.out.println(b);
		}
		bookMgrImpl.close();
		
	}
}
