package apllication;

import java.util.Locale;
import java.util.Scanner;
import util.Calculator_2;

public class Versao_2 {
	// Como o valor de PI e os metodos não são estáticos então eles precisam ser estanciados

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		Calculator_2 calc = new Calculator_2();
		
		System.out.print("Entre com o raio: ");
		double raio = entrada.nextDouble();
		
		double c = calc.circunferencia(raio);
		double v = calc.volume(raio);
		
		System.out.printf("Circunferência: %.2f\n", c);
		System.out.printf("Volume: %.2f\n", v);
		System.out.printf("PI: %.2f\n", calc.PI);
		
		entrada.close();
	}
	
}
