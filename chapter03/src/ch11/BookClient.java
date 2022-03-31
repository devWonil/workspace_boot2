package ch11;

public class BookClient {

	private static int serialBookNumber = 0;

	// 북 객체 생성
	public Book createBook(String title, String author) {
		serialBookNumber++;
		return new Book(title, author, serialBookNumber);
	}

	public void printTitle() {
		System.out.println("책 제목을 입력 합니다.");
		System.out.println("공백은 입력하지 마세요");
	}
}