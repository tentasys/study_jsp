package com.servlet.dto;

//BOOK에 대한 정보를 가지고 있으면 됨 
public class BookDTO {
	int bookId;
	String bookName;
	String bookLoc;
	
	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookLoc() {
		return bookLoc;
	}

	public BookDTO(int bookId, String bookName, String bookLoc) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookLoc = bookLoc;
	}
}
