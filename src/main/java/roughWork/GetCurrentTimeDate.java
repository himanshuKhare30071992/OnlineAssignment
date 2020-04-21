package roughWork;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentTimeDate {
	
	public static void main(String[] args) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY hh:mm:ss a");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println(currentDate);
	}

}
