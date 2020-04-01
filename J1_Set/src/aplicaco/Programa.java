package aplicaco;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Programa {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();  // velocidade intermediária e elementos na ordem em que são adicionados
		// Set<String> set = new TreeSet<>();  -- mais lento (O(log(n)) em árvore rubro-negra) e ordenado 
		// Set<String> set = new HashSet<>();  -- mais rápido (operações O(1) em tabela hash) e não ordenado
		
		set.add("TV");
		set.add("Notebook");
		set.add("Tablet");
		set.add("DVD");
		
		System.out.println(set.contains("Notebook")); 
		// set.removeIf(x -> x.length() >= 4); --- Remove variaveis com mais de 3 caracteres
		set.removeIf(x -> x.charAt(0) == 'T');
		
		for (String elem : set) {
			System.out.println(elem);
		}
		
		Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));
		
		//union
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.println("União: " + c);
		
		//intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println("Intersação: " + d);
		
		//difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println("Diferença: " + e);
	}
}
