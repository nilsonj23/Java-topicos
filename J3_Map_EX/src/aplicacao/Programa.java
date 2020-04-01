package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> votos = new LinkedHashMap<>();

		String caminho = "A:\\Documentos\\Programação\\Java\\eclipse-workspace\\J3_Map_EX\\src\\in.txt"	;

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			String linha = br.readLine();
			
			while (linha != null) {
				String[] fields = linha.split(",");
				String nome = fields[0];
				int count = Integer.parseInt(fields[1]);

				if (votos.containsKey(nome)) {
					int votesAteAgora = votos.get(nome);
					votos.put(nome, count + votesAteAgora);
				} else {
					votos.put(nome, count);
				}

				linha = br.readLine();
			}

			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}
