package com.ssafy.edu.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BookMgrImpl implements IBookMgr {
	
	private static BookMgrImpl bookMgrImpl;
	private BookMgrImpl() {}
	public static BookMgrImpl getInstance() {
		if(bookMgrImpl == null) {
			bookMgrImpl = new BookMgrImpl();
		}
		return bookMgrImpl;
	}
	// open할 때 book.txt에서 읽은 내용을 books로 
	private ArrayList<Book> books = new ArrayList<>();
	
	@Override
	public void add(Book b) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).equals(b)) {
				books.get(i).setQuantity(books.get(i).getQuantity() + b.getQuantity());
				System.out.println("이미 있는 도서입니다. 수량을 추가합니다.");
				return;
			}
		}
		books.add(b);
	}

	@Override
	public List<Book> search() {
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				if(books.get(i).getQuantity() < quantity) {
					throw new QuantityException();
				} else {
					books.get(i).setQuantity(books.get(i).getQuantity() - quantity);
					System.out.println(isbn + "(" + books.get(i).getTitle() + ") 도서가 " + quantity + "권 판매 되었습니다.\n남은 수량 :" + books.get(i).getQuantity());
					return;
				}
			}
		}
		throw new ISBNNotFoundException();
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				books.get(i).setQuantity(books.get(i).getQuantity() + quantity);
				System.out.println(isbn + "(" + books.get(i).getTitle() + ") 도서가 " + quantity + "권 입고 되었습니다.\n남은 수량 :" + books.get(i).getQuantity());
				return;
			}
		}
		throw new ISBNNotFoundException();
	}

	@Override
	public int getTotalAmount() {
		int total = 0;
		for(int i = 0; i < books.size(); i++) {
			total += (books.get(i).getPrice()*books.get(i).getQuantity());
		}
		return total;
	}

	@Override
	public void open() {
		String fname = "book.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fname));
			String msg = "";
			while((msg = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(msg, "[|]");
				int kind = Integer.parseInt(st.nextToken().trim());
				if(kind == 1) {
					books.add(new Book(st.nextToken().trim(), st.nextToken().trim(), Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim())));
				} else {
					books.add(new Magazine(st.nextToken().trim(), 	st.nextToken().trim(), Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim())));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중 예외가 발생했습니다.");
		}
	}

	@Override
	public void close() {
		String fname = "Book_List.txt";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(fname, false), true);
			for(int i = 0; i < books.size(); i++) {
				Book b = books.get(i);
				String msg = "";
				if(b instanceof Magazine) {
					msg = String.format("%d) ISBN:%s, TITLE:%s, PRICE:%d, QUANTITY:%d, MONTH:%d", i+1, b.getIsbn(), b.getTitle(), b.getPrice(), b.getQuantity(), ((Magazine) b).getMonth());
				} else {
					msg = String.format("%d) ISBN:%s, TITLE:%s, PRICE:%d, QUANTITY:%d", i+1, b.getIsbn(), b.getTitle(), b.getPrice(), b.getQuantity());
				}
				pw.println(msg);
			}
		} catch (IOException e) {
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}
	
	public void print() {
		for(Book b:books) {
			System.out.println(b);
		}
	}
	
}
