package curso;

import java.util.Locale;

public class B_TiposSaida {

	public static void main(String[] args) {
		String name = "Nilson";
		int idade = 25;
		char genero = 'M';
		double pi = 3.144863;
		
		System.out.printf("%.3f\n", pi);		// acontece o arrendondamento
		Locale.setDefault(Locale.US);			// Troca o tipo da formatação
		System.out.printf("%.3f\n", pi);		// \n ou %n para pular linha
		
		System.out.printf("%s tem %d de idade, e gênero %c", name, idade, genero);
		
	}

}
