package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.execptions.Exception01;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// CONSTRUTOR
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws Exception01 {
		if(!checkOut.after(checkIn)) {		// Testa se a data checkOut é posterior a data checkIn
			throw new Exception01("A data de Check-out deve ser posterior a data de Check-In");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	// GET e SET
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}

	// METODOS
	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut) throws Exception01{
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new Exception01("A data da reserva deve ser futura");
			// throw new IllegalArgumentException("A data da reserva deve ser futura");
		}
		if(!checkOut.after(checkIn)) {		// Testa se a data checkOut é posterior a data checkIn
			throw new Exception01("A data de Check-out deve ser posterior a data de Check-In");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	// toString
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto 
				+ ", check-in: " 
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";	
	}
	
}
