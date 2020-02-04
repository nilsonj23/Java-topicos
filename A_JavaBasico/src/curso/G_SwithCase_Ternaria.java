package curso;

import java.util.Scanner;

public class G_SwithCase_Ternaria {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite um número da semana:");
		int x = entrada.nextInt();
		String dia;
		
		switch (x) {
		case 1:
			dia = "Sunday";
			break;
		case 2:
			dia = "Monday";
			break;
		case 3:
			dia = "Tuesday";
			break;
		case 4:
			dia = "Wednesday";
			break;
		case 5:
			dia = "Thursday";
			break;
		case 6:
			dia = "Friday";
			break;
		case 7:
			dia = "Saturday";
			break;
		default:
			dia = "Invalid value";
		}
		System.out.println("Dia: " + dia);
		
		// Condição Ternária
		double nota = 7.5;
		String media = (nota >= 7) ? "Aprovado" : "Reprovado";
		System.out.println("Aluno: " + media);
		
		entrada.close();
	}
}
