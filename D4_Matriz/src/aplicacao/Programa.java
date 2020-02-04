package aplicacao;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Entre com o tamanho da ordem da matriz: ");
		int n = entrada.nextInt();
		int[][] mat = new int[n][n];
		
		System.out.println("Entre com os valores da matriz: ");
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				mat[i][j] = entrada.nextInt();
			}
		}
		
		System.out.println("Matriz diagonal: ");
		for (int i=0; i<mat.length; i++) {
			System.out.print(mat[i][i] + " ");  
		}
		
		System.out.println();
		int negativo = 0;
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				if (mat[i][j] < 0) {
					negativo++;
				}
			}
		}
		System.out.println("Numeros negativos: " + negativo);
		entrada.close();
	}
}