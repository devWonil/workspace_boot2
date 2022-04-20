package ch03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Diary implements WriteDiary {

	private String printDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		return dateFormat.format(Calendar.getInstance().getTime());
	}
	
	
	@Override
	public void printDiary(String diary) {
		System.out.println("****** 오늘의 일기 ******");
		System.out.println();
		System.out.println(diary);
		System.out.println();
		System.out.println("오늘 날짜 : " + printDate());
	}

}
