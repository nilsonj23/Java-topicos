package aplicacao;

import entidades.Conta;
import entidades.ContaEmpresa;
import entidades.ContaPoupanca;

public class Programa {

	public static void main(String[] args) {
		Conta conta = new Conta(1001, "Nilson", 0.0);
		ContaEmpresa contaE = new ContaEmpresa(1002, "Aperion", 0.0, 500.0);
		
		// UPCASTING	- 	Mas perde as informações que são da classe especifica
		Conta conta1 = contaE;
		Conta conta2 = new ContaEmpresa(1003, "Bob", 0.0, 200.0);
		Conta conta3 = new ContaPoupanca(1004, "Ana", 0.0, 0.01);

		// DOWNCASTING
		ContaEmpresa contaE1 = (ContaEmpresa)conta2;
		System.out.println(contaE1.getLimite());
		
		if (conta3 instanceof ContaEmpresa) {
			ContaEmpresa contaE2 = (ContaEmpresa)conta3;
			System.out.println("Limite: " + contaE2.getLimite());
		}
		if (conta3 instanceof ContaPoupanca) {
			ContaPoupanca contaE2 = (ContaPoupanca)conta3;
			System.out.println("Taxa de Juros: " + contaE2.getTaxaJuro());
		}
		System.out.println();
		
		// Override
		Conta conta4 = new Conta(1005, "Alex", 1000.0);
		conta4.saque(200.00);
		System.out.println("Saque: " + conta4.getSaldo());
		
		Conta contaP = new ContaPoupanca(1006, "Maria", 1000.0, 0.01);
		contaP.saque(200.00);
		System.out.println("Saque: " + contaP.getSaldo());
		System.out.println();
		
		// SUPER
		Conta contaE3 = new ContaEmpresa(1007, "Eduardo", 1000.0, 500.0);
		contaE3.saque(200.00);
		System.out.println("Saque: " + contaE3.getSaldo());
	}
}
