package entidades;

public class Conta {
	private int numero;
	private String nome;
	private double saldo;
	
	//Construtor
	public Conta(int numero, String nome, double saldo) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
	}

	//Get e Set
	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}
	
	//Metodos
	public void deposito(double valor) {
		saldo += valor;
	}
	
	public void saque(double valor) {
		saldo -= valor + 5.00;
	}

	public String toString() {
		return "Conta: " + getNumero() + ", Nome: " + getNome() + ", Saldo: R$ " + String.format("%.2f",getSaldo());
	}
}
