package ch02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarMainTest {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTimeInMillis());
		// 1650416863486 현재 시간 (1000분의 1초)
		// 보여주는 방식 각자 알아서 구현해라
		
		// 1650416863486
		// 보기 불편한 형식을 편하게 변환해서 사용하는 방법을 알아보자
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String date = dateFormat.format(calendar.getTimeInMillis());
		System.out.println(date);
	}

}
