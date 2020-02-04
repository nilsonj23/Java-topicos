package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Programa {

	public static void main(String[] args) {
		//Declarar uma interface de lista encadeada com um instaciamento de uma classe (ArrayList)
		List<String> lista = new ArrayList<>();
		
		//Adicinando elementos
		lista.add("Maria");
		lista.add("Alex");	
		lista.add("João");	
		lista.add("Ana");	
		lista.add("José");	
		lista.add("Nilson");
		lista.add("Junio");	
		lista.add("Mariana");
		lista.add(2, "Marcos");		// Adicionado o elemento na posição 2	
		
		System.out.println("Tamanho da lista: " + lista.size());
		for(String x : lista) {
			System.out.println(x);
		}
		
		System.out.println("---------");
		//Removendo elementos
		lista.remove("João");
		lista.remove(4);
		lista.removeIf(x -> x.charAt(0) == 'M');		// Predicado- retorna verdadeiro ou falso
		
		for(String x : lista) {
			System.out.println(x);
		}
		
		System.out.println("---------");
		System.out.println("Index do Nilson: " + lista.indexOf("Nilson"));
		System.out.println("Index do Mariana: " + lista.indexOf("Mariana"));
		String nome = lista.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);	// Primeiro elemento com a letra inicial A
		System.out.println(nome); 
		
		System.out.println("---------");
		List<String> resultado = lista.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
		for(String x : resultado) {
			System.out.println(x);
		}
	}
}
