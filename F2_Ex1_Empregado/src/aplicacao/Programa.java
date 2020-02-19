package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Empregado;
import entidades.Terceirizado;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Entre com a quantidade de funcionários: ");
		int qtd = entrada.nextInt();
		
		List<Empregado> lista = new ArrayList<>();
		for (int i=1; i<=qtd; i++) {
			System.out.println("Dados do empregado #" + i + ": ");
			System.out.print("É terceirizado (s/n)? ");
			char letra = entrada.next().charAt(0);
			
			System.out.print("Nome: ");
			entrada.nextLine();
			String nome = entrada.nextLine();
			
			System.out.print("Horas: ");
			int hora = entrada.nextInt();
			
			System.out.print("Valor por hora: ");
			double valorPorHora = entrada.nextDouble();
			
			if (letra == 's') {
				System.out.print("Despesa Adicional: ");
				double despesaAdicional = entrada.nextDouble();				
				lista.add(new Terceirizado(nome, hora, valorPorHora, despesaAdicional));
			}
			else {
				lista.add(new Empregado(nome, hora, valorPorHora));
			}
		}
		
		System.out.println();
		System.out.println("PAGAMENTOS:");
		for (Empregado emp : lista) {
			System.out.println(emp.getNome() + " - $ " + String.format("%.2f", emp.pagamento()));
			
		}
		
		entrada.close();
	}

}
