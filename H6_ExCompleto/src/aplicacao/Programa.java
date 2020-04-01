package aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entidades.Produto;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		
		String caminho = "A:\\Documentos\\Programação\\Java\\eclipse-workspace\\H6_ExCompleto\\src\\Produtos.csv";
		List<Produto> lista = new ArrayList<>();
		
		File arqFonte = new File(caminho);
		String pastaOrig = arqFonte.getParent();
		
		boolean sucesso = new File(pastaOrig + "\\saida").mkdir();
		String arqDestino = pastaOrig + "\\saida\\Produto Editado.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			String itemCsv = br.readLine();
			
			while (itemCsv != null) {
				String[] campos = itemCsv.split(",");
				String nome = campos[0];
				double preco = Double.parseDouble(campos[1]);
				int qtd = Integer.parseInt(campos[2]);

				lista.add(new Produto(nome, preco, qtd));
				itemCsv = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(arqDestino))) {

				for (Produto item : lista) {
					bw.write(item.getNome() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}

				System.out.println(arqDestino + "\nCRIADO COM SUCESSO!");
			}
			catch (IOException e) {
				System.out.println("Erro na escrita do arquivo: " + e.getMessage());
			}
		} 
		catch (IOException e) {
			System.out.println("Erro na leitura do arquivo: " + e.getMessage());
		}
			
	}		
}