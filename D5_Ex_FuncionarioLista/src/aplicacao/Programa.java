package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Quantos empregados serão registrados: ");
		int n = entrada.nextInt();
		
		List<Funcionario> lista = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			System.out.printf("\nEmpregado #%d:\n", i);
			System.out.print("Id: ");
			int id = entrada.nextInt();
			System.out.print("Nome: ");
			entrada.nextLine();
			String nome = entrada.nextLine();
			System.out.print("Salario: ");
			double salario = entrada.nextDouble();
			
			lista.add(new Funcionario(id, nome, salario));
		}
		
		System.out.printf("\nEntre com o Id do empregado que ira receber o aumento de salario: ");
		int id = entrada.nextInt();
		entrada.nextLine();

		double porcentagem = 0; 
		Funcionario fun = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		if (fun == null) {
			System.out.println("Esse Id não existe!");
		}
		else {
			System.out.print("Entre com a porcentagem: ");
			porcentagem = entrada.nextDouble();
			fun.aumentoSalario(porcentagem);
		}
		
		System.out.printf("\nLista de funcionarios: \n");
		for(Funcionario obj : lista) {
			System.out.println(obj);
		}

		entrada.close();
	}

}
