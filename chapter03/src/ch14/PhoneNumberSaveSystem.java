package ch14;

import java.util.Scanner;

public class PhoneNumberSaveSystem {

	public static void main(String[] args) {
		
		PhoneBookClient bookClient = new PhoneBookClient();
		// 다형성
		PhoneBookService bookArrayList = new PhoneBookArrayList();
		//BookService bookArrayList = new BookArray();
		
		
		Scanner scanner = new Scanner(System.in);
		String selectedMenu = "";
		
		do {
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("1. 전화번호 생성 2. 전화번호 조회 3. 전화번호 삭제 4. 전화번호 전체 조회 5. 전화번호 수정 0. 프로그램 종료");
			System.out.println("----------------------------------------------------------------------------------------------------------");
			selectedMenu = scanner.nextLine();
			
			if(selectedMenu.equals("0")) {
				System.out.println("프로그램을 종료 합니다.");
				scanner.close();
			} else if(selectedMenu.equals("1")) {
				bookClient.printPhoneNumber();
				
				String phoneNumber = removeBlankString(scanner.nextLine());
				System.out.println("이름을 입력 하세요");
				String name = removeBlankString(scanner.nextLine());
				System.out.println("이메일을 입력 하세요");
				String email = removeBlankString(scanner.nextLine());
				PhoneNumberBook book = bookClient.createPhoneBook(phoneNumber, name, email);
				bookArrayList.addPhoneNumber(book);
			} else if(selectedMenu.equals("2")) {
				System.out.println("이름을 입력해 주세요");
				String name = removeBlankString(scanner.nextLine()); 
				bookArrayList.selectedByName(name);
			} else if(selectedMenu.equals("3")) {
				System.out.println("삭제 하려는 이름을 입력해 주세요.");
				String name = removeBlankString(scanner.nextLine()); 
				bookArrayList.deletePhoneNumber(name);
			} else if(selectedMenu.equals("4")) {
				System.out.println("저장 되어 있는 전화번호 목록 조회");
				bookArrayList.showAllPhoneNumber();
			} else if(selectedMenu.equals("5")) {
				System.out.println("수정 하려는 전화번호의 사람을 입력해 주세요");
				String name = removeBlankString(scanner.nextLine());
				System.out.println("새로운 전화번호를 입력 하세요");
				String phoneNumber = removeBlankString(scanner.nextLine());
				System.out.println("새로운 이메일을 입력 하세요");
				String email = removeBlankString(scanner.nextLine());
				PhoneNumberBook book =  bookClient.createPhoneBook(phoneNumber, name, email);
				bookArrayList.updatePhoneNumber(name, book);
			} else {
				System.out.println("잘못된 입력입니다.");
			}
			
		} while (!selectedMenu.equals("0"));
		
	} // end of main 
	
	public static String removeBlankString(String str) {
		String result1 = str.trim();
		String result2 = result1.replace(" ", "");
		return result2;
	}
	
	

} // end of class 