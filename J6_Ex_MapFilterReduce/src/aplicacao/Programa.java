package aplicacao;

/*
  Fazer um programa para ler um conjunto de produtos a partir de um
  arquivo em formato .csv (suponha que exista pelo menos um produto).
  Em seguida mostrar o preço médio dos produtos. Depois, mostrar os
  nomes, em ordem decrescente, dos produtos que possuem preço
  inferior ao preço médio.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String path = "A:\\Documentos\\Programação\\Java\\eclipse-workspace\\J6_Ex_MapFilterReduce\\src\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Produto> list = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Produto(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}

			// Media
			double media = list.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y) / list.size();

			System.out.println("Preço médio: " + String.format("%.2f", media));

			// Ordenação decrescente apartir da media
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

			List<String> names = list.stream().filter(p -> p
					.getPrice() < media)
					.map(p -> p.getName())
					.sorted(comp.reversed())
					.collect(Collectors.toList());

			names.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
