package ch03;

public class MyDiary {

	String diary;
	WriteDiary onWriteDiary;
	
	public MyDiary(String diary, WriteDiary onWriteDiary) {
		this.diary = diary;
		this.onWriteDiary = onWriteDiary;
	}
	
	public void complete() {
		onWriteDiary.printDiary(diary);
	}
}
