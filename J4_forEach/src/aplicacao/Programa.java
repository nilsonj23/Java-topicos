package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		
		List<Produto> lista = new ArrayList<>();

		lista.add(new Produto("Tv", 900.00));
		lista.add(new Produto("Mouse", 50.00));
		lista.add(new Produto("Tablet", 350.50));
		lista.add(new Produto("HD Case", 80.90));

		// Predicate - Aumenta todos os produtos em 10%
		double fator = 1.1;
		lista.forEach(p -> p.setPreco(p.getPreco() * fator));
		lista.forEach(System.out::println);
		System.out.println();

		// Consumer - Remove os produtos menor do que 100.0
		double min = 100.0;
		lista.removeIf(p -> p.getPreco() >= min);
		lista.forEach(System.out::println);
		System.out.println();
		
		// Function -  Nova lista contendo o nome dos produtos em maiusculo
		//lista.forEach(p -> p.setNome(p.getNome().toUpperCase()));
		List<String> nomes = lista.stream().map(p -> p.getNome().toUpperCase()).collect(Collectors.toList());
		nomes.forEach(System.out::println);


	}
}
