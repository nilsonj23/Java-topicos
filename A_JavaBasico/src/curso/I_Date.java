package curso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class I_Date {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dataFormt1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dataFormt2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date dataNow1 = new Date();
		Date dataNow2 = new Date(System.currentTimeMillis());	// Em milisegundos
		Date x = new Date(0L);
		Date data1 = dataFormt1.parse("29/06/2020");
		Date data2 = dataFormt2.parse("29/06/2020 15:42:07");
		
		System.out.println("Data corrente1: " + dataNow1);
		System.out.println("Data corrente1: " + dataFormt2.format(dataNow1));
		System.out.println("Data corrente2: " + dataFormt2.format(dataNow2));
		System.out.println("Data X: " + dataFormt2.format(x));
		System.out.println("Data1: " + dataFormt2.format(data1));
		System.out.println("Data2: " + dataFormt2.format(data2));
	}
}
