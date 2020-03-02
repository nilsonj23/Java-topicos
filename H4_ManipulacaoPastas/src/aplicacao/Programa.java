package aplicacao;

import java.io.File;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Entre com o caminho da pasta: ");
		String strCaminho = entrada.nextLine();
		
		File caminho = new File(strCaminho);
		File[] pastas = caminho.listFiles(File::isDirectory);
		System.out.println("PASTAS:");
		for (File pasta : pastas) {
		System.out.println(pasta);
		}
		
		System.out.println();
		
		File[] arquivos = caminho.listFiles(File::isFile);
		System.out.println("ARQUIVOS:");
		for (File arquivo : arquivos) {
		System.out.println(arquivo);
		}
		
		System.out.println();
		boolean sucesso = new File(strCaminho + "\\subPasta").mkdir();
		System.out.println("Pasta criada com sucesso: " + sucesso);
		entrada.close();
	}

}
