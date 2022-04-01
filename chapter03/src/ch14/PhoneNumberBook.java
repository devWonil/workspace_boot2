package ch14;

public class PhoneNumberBook {

	private String name;
	private String phoneNumber;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "전화번호부 [이름=" + name + ", 전화번호=" + phoneNumber + ", email=" + email + "]";
	}

	public PhoneNumberBook(String phoneNumber, String name, String email) {
		
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.email = email;
	}

}
