package ch14;

public class PhoneBookClient {

	//public static int serialPhoneBookNumber = 0;

	// 전화번호 객체 생성
	public PhoneNumberBook createPhoneBook(String phoneNumber,String name, String email) {
		//serialPhoneBookNumber++;
		return new PhoneNumberBook(phoneNumber, name, email);
	}

	public void printPhoneNumber() {
		System.out.println("전화번호를 입력 합니다.");
		System.out.println("공백은 입력하지 마세요");
	}
}