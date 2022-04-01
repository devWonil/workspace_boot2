package ch11;

public class BookArray implements BookService{
	
	int shelfSize = 10;
	Book[] books = new Book[shelfSize];

	@Override
	public void addBook(Book book) {
		for (int i = 0; i < shelfSize; i++) {

			while(books[i] == null)
			{
				books[i] = book;
				showAllBook();
				return;
			}
		}
		System.out.println("저장할 공간이 부족합니다.");	
	}

	@Override
	public void updateBook(String title, Book book) {
		
		for (int i = 0; i < shelfSize; i++) {

			while(books[i].getTitle().equals(title)) 
			{
				books[i] = book;
				showAllBook();
				return;
			}
			continue;
		}
		
		System.out.println( title + " 책이 없습니다.");
	}

	@Override
	public void deleteBook(String title) {
		for (int i = 0; i < shelfSize; i++) {

			while(books[i].getTitle().equals(title)) {
				books[i] = null;
				showAllBook();
				System.out.println( title + " 책을 삭제하였습니다.");
				return;	
			}
			continue;
		}
		
	}


	@Override
	public void selectedByTitleBook(String title) {
		for (int i = 0; i < shelfSize; i++) {

			while(books[i].getTitle().equals(title)) {
				System.out.println(books[i]);
				return;
			}
			continue;
		}
		System.out.println( title + " 책이 없습니다.");
	}

	@Override
	public void showAllBook() {
		for (int i = 0; i < shelfSize; i++) {
			if(books[i] == null) {
				continue;
			}else {
				System.out.println(books[i]);
			}
			
		}
	}
	
}