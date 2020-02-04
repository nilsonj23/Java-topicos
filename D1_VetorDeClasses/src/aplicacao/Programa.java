package aplicacao;

import java.util.Locale;
import java.util.Scanner;
import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);

		System.out.print("Insira o tamanho do vetor: ");
		int n = entrada.nextInt();
		Produto[] vet = new Produto[n];
		
		for (int i=0; i<vet.length; i++) {
			entrada.nextLine();
			System.out.print("Insira o nome do produto: ");
			String nome = entrada.nextLine();
			System.out.print("Insira o valor do produto: ");
			double preco = entrada.nextDouble();
			
			vet[i] = new Produto(nome, preco);
		}
		
		double precoTot = 0;
		for (int i=0; i<vet.length; i++) {
			precoTot += vet[i].getPreco();
		}
		
		double media = precoTot / n;
		System.out.printf("A média dos valores é: R$ %.2f\n", media);
		entrada.close();
	}
}
