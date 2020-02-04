package entidades;

public class Funcionario {
	public String nome;
	public double salarioBruto, imposto;
	
	public double salarioLiquido() {
		return salarioBruto - imposto;
	}
	
	public void aumentoSalario(double porcentagem) {
		salarioBruto += salarioBruto * porcentagem / 100.0;
	}
	
	public String toString() {
		return nome + ", R$ " + String.format("%2.f", salarioLiquido());
	}

}
