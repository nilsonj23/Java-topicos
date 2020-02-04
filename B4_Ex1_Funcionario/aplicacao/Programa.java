package aplicacao;

import java.util.Scanner;
import entidades.Funcionario;

public class Programa {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Funcionario func = new Funcionario();

		System.out.print("Nome: ");
		func.nome = entrada.nextLine();
		
		System.out.print("Salário Bruto: ");
		func.salarioBruto = entrada.nextDouble();
		
		System.out.print("Imposto: ");
		func.imposto = entrada.nextDouble();
		
		System.out.println();
		System.out.println("O empregado " + func.toString());
		
		System.out.print("Porcentagem de aumento de salário: ");
		double porcentagem = entrada.nextDouble();

		func.aumentoSalario(porcentagem);
		
		System.out.println("Dados atualizados: " + func.toString());
		
		entrada.close();
	}

}
