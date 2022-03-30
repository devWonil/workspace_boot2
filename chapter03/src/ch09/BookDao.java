package ch09;

public interface BookDao {

	// 저장하는 메소드
	void createBookDao(BookInfo bookInfo);
	
	// 수정하는 메소드
	void updateBookDao(BookInfo bookInfo);
	
	// 삭제하는 메소드
	void deleteBookDao(BookInfo bookInfo);
	
	// 출력하는 메소드
	void readBookDao(BookInfo bookInfo);
}
