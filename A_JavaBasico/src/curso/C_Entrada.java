package curso;

import java.util.Scanner;

public class C_Entrada {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		char genero, letra;
		int n1, digito;
		double n2;
		String nome, aux;
		
		System.out.println("Insira um número:");
		n1 = entrada.nextInt();		// Atribui o primeiro conjunto de números --apenas a primeira palavra digitada
		
		System.out.println("Insira o seu nome:");
		nome = entrada.nextLine();	// Atribui a linha toda até a quebra de linha
		
		System.out.println("Insira o seu gênero:");
		genero = entrada.next().charAt(0); // Atribuir apenas uma letra
		
		System.out.println("Insira um código com uma letra e um número:");
		aux = entrada.next();
		letra = aux.charAt(0);				// Atribui apenas a primeira letra de uma string contida em um variável		
		digito = Integer.parseInt(aux.substring(1));	// Atribui um numero a partir de umcerto ponto dado

		System.out.println("Insira um número com ponto flutuante:");
		n2 = entrada.nextDouble();		// Atribui um número do tipo double
		
		System.out.println(n1);
		System.out.println(nome);
		System.out.println(genero);
		System.out.println(letra);
		System.out.println(digito);
		System.out.println(n2);
		
		System.out.println("Insira a seguir: Maria f 23 1,68");
		String nome2 = entrada.next();
		char ch = entrada.next().charAt(0);
		int idade = entrada.nextInt();
		double altura = entrada.nextDouble();
		
		System.out.println(nome2);
		System.out.println(ch);
		System.out.println(idade);
		System.out.println(altura);
		
		entrada.close();
	}
}
