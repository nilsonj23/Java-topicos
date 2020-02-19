package entidades;

public class Terceirizado extends Empregado{
	private Double despesaAdicional;
	
	// CONSTRUTOR
	public Terceirizado() {
	}
	
	public Terceirizado(String nome, int hora, Double valorPorHora, Double despesaAdicional) {
		super(nome, hora, valorPorHora);
		this.despesaAdicional = despesaAdicional;
	}

	// GET e SET
	public Double getDespesaAdicional() {
		return despesaAdicional;
	}

	public void setDespesaAdicional(Double despesaAdicional) {
		this.despesaAdicional = despesaAdicional;
	}
	
	// METODOS
	@Override
	public Double pagamento() {
		return super.pagamento() + (despesaAdicional * 110 /100);
	}
}
