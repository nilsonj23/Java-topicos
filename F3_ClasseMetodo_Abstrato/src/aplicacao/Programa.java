package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entidades.Circulo;
import entidades.Figura;
import entidades.Retangulo;
import entidades.enums.Cor;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Entre com o número de figuras: ");
		int qtd = entrada.nextInt();
		
		List<Figura> lista = new ArrayList<>();
		
		for (int i=1; i<=qtd; i++) {
			System.out.println("Dados da #" + i + " figura:");
			System.out.print("Ratengulo ou circulo (r/c)? ");
			char letra = entrada.next().charAt(0);
			
			System.out.print("Cor (BLACK/BLUE/RED): ");
			Cor cor = Cor.valueOf(entrada.next());
			
			if (letra == 'r') {
				System.out.print("Largura: ");
				double largura = entrada.nextDouble();
				
				System.out.print("Altura: ");
				double altura = entrada.nextDouble();
				lista.add(new Retangulo(cor, largura, altura));
			} 
			else {
				System.out.print("Raio: ");
				double raio = entrada.nextDouble();
				lista.add(new Circulo(cor, raio));
			}
		}
		
		System.out.println();
		System.out.println("ÁREA DAS FIGURAS:");
		for (Figura figura : lista) {
			System.out.println(String.format("%.2f", figura.area()));
		}
		
		entrada.close();
	}
}
