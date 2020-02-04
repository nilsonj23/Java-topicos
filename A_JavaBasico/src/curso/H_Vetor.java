package curso;

import java.util.Locale;
import java.util.Scanner;

public class H_Vetor {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Insira o tamanho do vetor: ");
		int tam = entrada.nextInt();
		
		double[] vet = new double[tam];
		
		double soma = 0;
		for(int i=0; i<tam; i++) {
			System.out.print("Insira a " + (i+1) + ") alturas: ");
			vet[i] = entrada.nextDouble();
			soma += vet[i];
		}
		
		double media = soma / tam;
		System.out.printf("A média das alturas é: %.2f\n", media);
		entrada.close();
	}

}
