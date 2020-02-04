package aplicacao;

import java.util.Scanner;
import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Entre com os dados do produto");
		System.out.print("Nome: ");
		String nomeAux = entrada.nextLine();
		System.out.print("Preço: ");
		double precoAux = entrada.nextDouble();
		
		Produto produto = new Produto(nomeAux, precoAux);
		
		produto.setNome("Computador");
		System.out.println("Nome atualizado para: " + produto.getNome());
		
		System.out.println();
		System.out.println("Dados do produto " + produto.toString());
		
		System.out.println();
		System.out.print("Entre com o numero de produtos para ser adicionado no estoque: ");
		int quantidade = entrada.nextInt();
		produto.adiconarProdutos(quantidade);
		
		System.out.println();
		System.out.println("Dados atualizado do produto " + produto.toString());
		
		System.out.println();
		System.out.print("Entre com o numero de produtos para ser removidos do estoque: ");
		quantidade = entrada.nextInt();
		produto.removerProdutos(quantidade);
		
		System.out.println();
		System.out.println("Dados atualizado do produto " + produto.toString());		
		
		entrada.close();
	}

}
