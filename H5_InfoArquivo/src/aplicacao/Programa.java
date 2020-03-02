package aplicacao;

import java.io.File;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Entrar com o caminho do arquivo: ");
		String strCaminho = entrada.nextLine();
		File caminho = new File(strCaminho);
		
		System.out.println();
		System.out.println("Endereço comleto: " + caminho.getPath());
		System.out.println("Endereço: " + caminho.getParent());
		System.out.println("Nome do arquivo: " + caminho.getName());
		System.out.println("Tamanho do arquivo: " + caminho.length());
		
		entrada.close();
	}
}