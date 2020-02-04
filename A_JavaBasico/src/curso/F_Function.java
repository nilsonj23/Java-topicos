package curso;
import java.util.Scanner;
public class F_Function {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Entre com três números:");
		int a = entrada.nextInt();
		int b = entrada.nextInt();
		int c = entrada.nextInt();
		int maior = maior(a, b, c);
		showResult(maior);
		entrada.close();
	}

	public static int maior(int x, int y, int z) {
		int aux;
		if (x > y && x > z) {
			aux = x;
		} else if (y > z) {
			aux = y;
		} else {
			aux = z;
		}
		return aux;
	}

	public static void showResult(int valor) {
		System.out.println("Maior = " + valor);
	}
}