package aplicacao;

import java.util.Locale;
import java.util.Scanner;
import entidades.Conta;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Entre com o número da conta: ");
		int numero = entrada.nextInt();
		System.out.print("Entre com o nome da conta: ");
		entrada.nextLine();
		String nome = entrada.nextLine();
		System.out.print("Existe depósito inicial (S/N): ");
		char aux = entrada.next().charAt(0);
		
		double valor = 0;
		if ((aux == 'S') || (aux == 's') ) {
			System.out.print("Entre com o valor inicial: ");
			valor = entrada.nextDouble();
		}
		
		Conta conta = new Conta(numero, nome, valor);
		System.out.printf("\nDados da conta: \n" + conta.toString() + "\n \n");
		
		System.out.print("Entrar com o valor de depósito: ");
		conta.deposito(entrada.nextDouble());
		System.out.printf("Dados atualizado da conta: \n" + conta.toString() + "\n \n" );
		
		System.out.print("Entrar com o valor de saque: ");
		conta.saque(entrada.nextDouble());
		System.out.printf("Dados atualizado da conta: \n" + conta.toString() + "\n \n" );
		
		entrada.close();
	}

}
