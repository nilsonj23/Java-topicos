package entidades;

public class Conta {
	private Integer numero;
	private String titular;
	protected Double saldo;
	
	// CONSTRUTOR
	public Conta() {
	}

	public Conta(Integer numero, String titular, Double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	// GET e SET
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	// METODOS
	public void saque(Double valor) {
		saldo -= valor + 5.0;
	}
	
	public void deposito(Double valor) {
		saldo += valor;
	}
	
	
	
}
