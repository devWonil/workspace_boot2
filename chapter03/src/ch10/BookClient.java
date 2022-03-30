package ch10;

import java.util.Scanner;

import ch08.Book;

public class BookClient {

	Scanner scn = new Scanner(System.in);
	
	//사용자한테 Book 객체를 생성하는 메소드 기능을 만든다
	public Book createBookObj() {
		System.out.println("책 생성해주세요");
		int bookId = scn.nextInt();
		String bookTitle = scn.next();
		String author = scn.next();
		
		return new Book(bookId, bookTitle, author);
	}
	
	//책정보 확인
	public void showBookInfo(int index) {
		
	}
	
	//삭제
	public void deleteBook(String title) {
		
	}
	
	//수정
	public void updateBook(int index, Book book) {
		
	}
}
