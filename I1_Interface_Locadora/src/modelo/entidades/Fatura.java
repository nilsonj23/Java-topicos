package modelo.entidades;

public class Fatura {
	private Double PagBasico;
	private Double taxa;
	
	// CONSTRUTOR
	public Fatura() {
	}
	public Fatura(Double pagBasico, Double taxa) {
		this.PagBasico = pagBasico;
		this.taxa = taxa;
	}
	
	// GET e SET
	public Double getPagBasico() {
		return PagBasico;
	}
	public void setPagBasico(Double pagBasico) {
		PagBasico = pagBasico;
	}
	public Double getTaxa() {
		return taxa;
	}
	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	// METODOS
	public Double getPagTotal() {
		return getPagBasico() + getTaxa();
	}
}
