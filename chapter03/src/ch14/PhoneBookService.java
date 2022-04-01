package ch14;

public interface PhoneBookService {

	// 전화번호 객체를 저장하는 기능
	void addPhoneNumber(PhoneNumberBook phoneNumberBook);
	
	// 전화번호 객체를 수정하는 기능 (ArrayList 인덱스에 접근해서 객체 교체)
	// String title
	void updatePhoneNumber(String name, PhoneNumberBook phoneNumberBook);
	
	// 전화번호 객체를 삭제
	void deletePhoneNumber(String name);
	
	// 전화번호 정보를 출력
	void selectedByName(String name);
	
	// ArrayList에 저장되어 있는 전화번호 정보를 전부 출력
	void showAllPhoneNumber();
}
