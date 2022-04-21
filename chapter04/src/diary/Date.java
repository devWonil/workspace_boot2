package diary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {

	Calendar calendar = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	String date = dateFormat.format(calendar.getTimeInMillis());
	
}
