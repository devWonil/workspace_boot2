package ch10;

import java.util.Scanner;

import ch08.Book;

public class BookClient {

	Scanner scn = new Scanner(System.in);
	
	//사용자한테 Book 객체를 생성하는 메소드 기능을 만든다
	public Book createBook() {
		System.out.println("책 생성해주세요");
		int bookId = scn.nextInt();
		String bookTitle = scn.next();
		String author = scn.next();
		
		return new Book(bookId, bookTitle, author);
	}
	
	//책정보 확인
	public Book showBookInfo() {
		System.out.print("확인할 책 번호 입력하세요 : ");
		int bookId = scn.nextInt();
		String bookTitle = "";
		String author = "";
		
		return new Book(bookId, bookTitle, author);
	}
	
	//삭제
	public Book deleteBook(String title) {
		System.out.println("삭제할 책 번호 입력하세요 : ");
		int bookId = scn.nextInt();
		
		return new Book(bookId, "", "");
	}
	
	//수정
	public Book updateBook(int index, Book book) {
		System.out.println("수정할 책 번호 입력하세요 : ");
		int bookId = scn.nextInt();
		String bookTitle = scn.next();
		String author = scn.next();
		
		return new Book(bookId, bookTitle, author);
		
	}
}
