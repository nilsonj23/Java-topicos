package entidades;

public class ContaEmpresa extends Conta {
	private Double limite;
	
	// CONSTRUTOR
	public ContaEmpresa() {
	}

	public ContaEmpresa(Integer numero, String titular, Double saldo, Double limite) {
		super(numero, titular, saldo);
		this.limite = limite;
	}

	// GET e SET
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	// METODO
	public void emtrestimo(Double valor) {
		if (valor <= limite) {
			saldo += valor - 10;
		}
	}
	
	@Override
	public void saque(Double valor) {
		super.saque(valor);				// Chama primeiro o método da classe Conta(desconta 5.0) e nesse metodo desconta mais 2.0
		saldo -= 2.0;
	}
	

}
