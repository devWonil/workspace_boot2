package ch03;

public class MainTest {

	public static void main(String[] args) {
		
		// 일기 생성
		Diary diary = new Diary();
		
		// 일기 작성
		MyDiary daily = new MyDiary("오늘 Java를 배웠다", diary);
		daily.complete();
	}

}
