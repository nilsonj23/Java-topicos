package apllication;

import java.util.Locale;
import java.util.Scanner;
import util.Calculator_2;
import util.Calculator_3;

public class Versao_3 {
	// Como valor de PI e os metodos não sofrem alterações eles são transformados em estáticos então eles não precisam ser estanciados

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Entre com o raio: ");
		double raio = entrada.nextDouble();
		
		double c = Calculator_3.circunferencia(raio);
		double v = Calculator_3.volume(raio);
		
		System.out.printf("Circunferência: %.2f\n", c);
		System.out.printf("Volume: %.2f\n", v);
		System.out.printf("PI: %.2f\n", Calculator_3.PI);
		
		entrada.close();
	}
	
}
