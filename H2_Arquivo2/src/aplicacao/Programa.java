package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) {
		String caminho = "A:\\Documentos\\Programação\\Java\\eclipse-workspace\\H2_Arquivo2\\Texto.txt";
			
		// Com o BufferedReader a leitura é fica mais rápida
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String linha = br.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		}
		catch (IOException e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
}