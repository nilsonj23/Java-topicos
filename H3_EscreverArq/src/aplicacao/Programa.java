package aplicacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) {
		String[] linhas = new String[] {"Good Morning\n" + "Good Afternoon\n" + "Good Night\n	"};
		String caminho = "A:\\Documentos\\Programa��o\\Java\\eclipse-workspace\\H3_EscreverArq\\Texto.txt";
						
													//  FileWriter(caminho, true) - adiciona no final do arquivo, e n�o o recria
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))){
			for (String linha : linhas) {
				bw.write(linha);
				bw.newLine();
			}
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
