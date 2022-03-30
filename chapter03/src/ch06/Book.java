package ch06;

public class Book {

	private int bookid;
	private String title;

	public Book(int bookid, String title) {
		super();
		this.bookid = bookid;
		this.title = title;
	}

	public boolean isSameBook(Book book) {
		if (book.title.equals(this.title)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + "]";
	}

	// Book이라는 클래스에 타이틀이 같으면 같은 객체다라고 재정의했음
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			// book이라는 클래스 타입이 들어오면 안에 접근해서 title을 확인
			Book tempBook = (Book) obj; // 다운캐스팅
			String title = tempBook.title;
			if (this.title == title) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

}
