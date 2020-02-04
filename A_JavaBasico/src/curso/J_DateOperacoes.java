package curso;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class J_DateOperacoes {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date data = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		System.out.println(sdf.format(data));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		
		cal.add(Calendar.HOUR_OF_DAY, 4);
		data = cal.getTime();
		System.out.println(sdf.format(data));

		int minutes = cal.get(Calendar.MINUTE);
		int month = 1 + cal.get(Calendar.MONTH);
		System.out.println("Minutes: " + minutes);
		System.out.println("Month: " + month);
	}

}
