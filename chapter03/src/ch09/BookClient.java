package ch09;

import java.util.Scanner;

public class BookClient {

	public static void main(String[] args) {
		// 스캐너 사용
		Scanner scn = new Scanner(System.in);
		
		// 사용자에게 bookInfo를 받는다
		BookInfo bookInfo = new BookInfo();
		
		BookDao bookDao = null;
		System.out.println("책정보 생성, 수정, 삭제, 출력프로그램입니다");
		System.out.println("1.생성\t2.수정\t3.삭제\t4.출력");
		int userChoice = scn.nextInt();
		// 생성
		if(userChoice == 1) {
			System.out.print("책ID : ");
			bookInfo.setBookId(scn.nextInt());
			
			System.out.print("책 제목 : ");
			bookInfo.setBookTitle(scn.next());
			
			System.out.print("작가 : ");
			bookInfo.setAuthor(scn.next());
			
			bookDao.createBookDao(bookInfo);
			
		}else if(userChoice == 2) {
			// 수정
			System.out.print("수정된 책ID : ");
			bookInfo.setBookId(scn.nextInt());
			
			System.out.print("수정된 책 제목 : ");
			bookInfo.setBookTitle(scn.next());
			
			System.out.print("수정된 작가 : ");
			bookInfo.setAuthor(scn.next());
			
			bookDao.updateBookDao(bookInfo);
			
		}else if(userChoice == 3) {
			// 삭제
			bookDao.deleteBookDao(bookInfo);
			
		}else if(userChoice == 4){
			// 출력
			bookDao.readBookDao(bookInfo);
			
		}else {
			System.out.println("잘못된 입력입니다");
		}
		
		
		
		
		
	}
	
}
