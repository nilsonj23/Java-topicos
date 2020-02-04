package application;

import java.util.Scanner;
import entidades.Triangulo;

public class A_Programa {
	
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		
		Triangulo x, y;
		x = new Triangulo();
		y = new Triangulo();
		
		System.out.println("Entre com os lados do tri�ngulo X: ");
		x.a = entrada.nextDouble();
		x.b = entrada.nextDouble();
		x.c = entrada.nextDouble();
		
		System.out.println("Entre com os lados do tri�ngulo Y: ");
		y.a = entrada.nextDouble();
		y.b = entrada.nextDouble();
		y.c = entrada.nextDouble();
		
		double areaX = x.area();
		double areaY = y.area();
		
		System.out.printf("A �rea do tri�ngulo X: %.4f%n", areaX);
		System.out.printf("A �rea do tri�ngulo Y: %.4f%n", areaY);
		if (areaX > areaY) {
			System.out.println("A maior �rea: X");
		} else {
			System.out.println("A maior �rea: Y");
		}
		entrada.close();
	}
}