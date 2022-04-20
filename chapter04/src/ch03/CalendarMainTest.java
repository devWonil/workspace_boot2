package ch03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarMainTest {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTimeInMillis());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String date = dateFormat.format(calendar.getTimeInMillis());
		System.out.println(date);
	}

}
