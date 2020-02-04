package aplicacao;

import java.util.Locale;
import java.util.Scanner;
import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);

		Produto produto = new Produto();
		
		System.out.println("Entre com os dados do produto");
		System.out.print("Nome: ");
		produto.nome = entrada.nextLine();
		System.out.print("Preço: ");
		produto.preco = entrada.nextDouble();
		System.out.print("Quantidade em estoque: ");
		produto.qtd = entrada.nextInt();
		
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
