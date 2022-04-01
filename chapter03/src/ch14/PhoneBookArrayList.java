package ch14;

import java.util.ArrayList;

public class PhoneBookArrayList implements PhoneBookService {

	private ArrayList<PhoneNumberBook> books = new ArrayList<PhoneNumberBook>();

	
	public PhoneBookArrayList() {
		PhoneNumberBook book1 = new PhoneNumberBook( "01012345678", "홍길동1", "fdsf@fds.com");
		PhoneNumberBook book2 = new PhoneNumberBook( "01012345679", "홍길동2","fdsf@fds.com");
		PhoneNumberBook book3 = new PhoneNumberBook( "01012345680", "홍길동3","fdsf@fds.com");
		PhoneNumberBook book4 = new PhoneNumberBook( "01012345681", "홍길동4","fdsf@fds.com");
		PhoneNumberBook book5 = new PhoneNumberBook( "01012345682", "홍길동5","fdsf@fds.com");
		PhoneNumberBook book6 = new PhoneNumberBook( "01012345677", "홍길동6","fdsf@fds.com");
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
	}

	/**
	 * Book 객체를 ArrayList 자료 구조에 저장하기
	 */
	@Override
	public void addPhoneNumber(PhoneNumberBook book) {
		System.out.println("저장 합니다.");
		books.add(book);
		showAllPhoneNumber();
	}

	/**
	 * 책에 이름으로 번호 존재 여부 확인 있다면 매개 변수로 넘어 오는 Book 객체를 수정한다.
	 */
	@Override
	public void updatePhoneNumber(String name, PhoneNumberBook book) {
		System.out.println("수정합니다.");
		// 책 타이틀로 인덱스 번호를 찾아야 한다.
		int bookIndex = -1;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getName().equals(name)) {
				// 번호가 존재
				bookIndex = i;
			}
		}
		if (bookIndex == -1) {
			System.out.println(name + " 이름의 번호가 존재하지 않습니다");
		} else {
			books.set(bookIndex, book);
		}
		showAllPhoneNumber();
	}

	/**
	 * 이름으로 ArrayList 에 객체를 삭제 합니다.
	 */
	@Override
	public void deletePhoneNumber(String name) {
		System.out.println("삭제합니다.");
		boolean deleteOk = false;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getName().equals(name)) {
				books.remove(i);
				deleteOk = true;
			}
		}
		if (deleteOk) {
			System.out.println(name + " 번호 삭제 하였습니다.");
		} else {
			System.out.println(name + " 번호 존재 하지 않습니다.");
		}
		showAllPhoneNumber();
	}

	/**
	 * 이름에 해당하는 객체에 정보를 출력 합니다.
	 */
	@Override
	public void selectedByName(String name) {
		System.out.println("조회 합니다.");
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getName().equals(name)) {
				System.out.println(books.get(i));
				return;
			}
		}
		System.out.println(name + " 이름으로 번호를 찾을 수 없습니다.");
	}

	/**
	 * 모든 데이터를 출력
	 */
	@Override
	public void showAllPhoneNumber() {
		System.out.println(">>>>> 현재 저장된 데이터 확인 <<<<<");
		for (PhoneNumberBook book : books) {
			System.out.println(book);
		}
	}
}