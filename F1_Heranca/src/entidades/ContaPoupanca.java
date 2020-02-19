package entidades;

public final class ContaPoupanca extends Conta{		// Final- Não permite que se crie outra classe estendendo dessa clase
	private Double taxaJuro;

	// CONSTRUTOR
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(Integer numero, String titular, Double saldo, Double taxaJuro) {
		super(numero, titular, saldo);
		this.taxaJuro = taxaJuro;
	}

	// GET e SET
	public Double getTaxaJuro() {
		return taxaJuro;
	}

	public void setTaxaJuro(Double taxaJuro) {
		this.taxaJuro = taxaJuro;
	}
	
	// METODOS
	public void atualizarSaldo() {
		saldo += saldo * taxaJuro;
	}
	
	@Override
	public final void saque(Double valor) {		// Final- Não permite que este metodo seja sobrescrito (@Override) 
		saldo -= valor;
	}
}
