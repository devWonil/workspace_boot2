package ch10;

public class MainTest {

	public static void main(String[] args) {
		
		BookClient bookClient = new BookClient();
		
		bookClient.createBook();
		bookClient.deleteBook("홍길동전");
		
		BookDaoMySql bookDaoMySql = new BookDaoMySql();
		bookDaoMySql.addBook(null);
	}

}
