package ch09;

import java.util.ArrayList;
import java.util.Scanner;

import ch06.Book;

public class BookDaoMySql implements BookDao{

	ArrayList<Book> books;
	// 인터페이스를 활용해서 기능구현
	// ArrayList 사용
	
	// 샘플코드
	public void insert(Book book) {
		books.add(book);
	}
	
	Scanner scn = new Scanner(System.in);
	@Override
	public void createBookDao(BookInfo bookInfo) {
		
		books.add(0, null);
	}
	@Override
	public void updateBookDao(BookInfo bookInfo) {
//		System.out.println("수정된 책ID : " + bookInfo.getBookId());
//		System.out.println("수정된 책제목 : " + bookInfo.getBookTitle());
//		System.out.println("수정된 작가 : " + bookInfo.getAuthor());
		books.set(0, null);
	}
	@Override
	public void deleteBookDao(BookInfo bookInfo) {
		System.out.println("삭제할 책ID를 입력하세요");
		int removedBookIndex = scn.nextInt();
		books.remove(removedBookIndex);
		System.out.println("해당 책 정보가 삭제되었습니다");
	}
	@Override
	public void readBookDao(BookInfo bookInfo) {
		books.get(0);
	}
}
