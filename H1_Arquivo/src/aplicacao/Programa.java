package aplicacao;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		File arquivo = new File("A:\\Documentos\\Programação\\Java\\eclipse-workspace\\H1_Arquivo\\Texto.txt");
		Scanner entrada = null;
		
		try {
			entrada = new Scanner(arquivo);
			while (entrada.hasNextLine()) {
				System.out.println(entrada.nextLine());
			}
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		finally {
			if (arquivo.exists()) {
				entrada.close();
			}
		}
	}
}
