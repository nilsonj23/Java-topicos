package apllication;

import java.util.Locale;
import java.util.Scanner;

public class Versao_1 {
	// As funções tem que ser estáticas porque o programa main é estático
	
	public static final double PI = 3.14159;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Entre com o raio: ");
		double raio = entrada.nextDouble();
		
		double c = circunferencia(raio);
		double v = volume(raio);
		
		System.out.printf("Circunferência: %.2f\n", c);
		System.out.printf("Volume: %.2f\n", v);
		System.out.printf("PI: %.2f\n", PI);
		
		entrada.close();
	}
	
	public static double circunferencia(double raio) {
		return 2 * PI * raio;
	}

	public static double volume(double raio) {
		return 4 * PI * raio * raio * raio / 3;
	}
}
