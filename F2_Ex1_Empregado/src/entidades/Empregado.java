package entidades;

public class Empregado {
	private String nome;
	private Integer hora;
	private Double valorPorHora;
	
	// CONSTRUTOR
	public Empregado() {
	}

	public Empregado(String nome, int hora, Double valorPorHora) {
		this.nome = nome;
		this.hora = hora;
		this.valorPorHora = valorPorHora;
	}

	// GET e SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	
	// METODOS
	public Double pagamento() {
		return hora * valorPorHora;
	}
	
}
