package curso;

public class D_FuncoesString {

	public static void main(String[] args) {
		String original, modificada;
		int indice;
		
		original = "abcde FGHIJ ABC abc DEFG   ";
		System.out.println("Original:  -" + original + "-");
		
		modificada = original.toLowerCase();
		System.out.println("Minúsculo: -" + modificada + "-");
		
		modificada = original.toUpperCase();
		System.out.println("Maiúsculo: -" + modificada + "-");
		
		modificada = original.trim();
		System.out.println("Tira os espaços das estremidades: -" + modificada + "-");
		
		modificada = original.substring(2);
		System.out.println("Cortar apartir de um certo ponto: -" + modificada + "-");
		
		modificada = original.substring(2,9);
		System.out.println("Cortar um pedaço específico: -" + modificada + "-");
		
		modificada = original.replace('a','x');
		System.out.println("Tocar substring: -" + modificada + "-");
		
		modificada = original.replace("abc","xy");
		System.out.println("Tocar substring: -" + modificada + "-");
		
		indice = original.indexOf("bc");
		System.out.println("O indice começa: " + indice);
		
		indice = original.lastIndexOf("bc");
		System.out.println("O indice termina: " + indice);
		
		
		String s = "potato apple lemon";
		String[] vect = s.split(" ");
		String word1 = vect[0];
		String word2 = vect[1];
		String word3 = vect[2];
		System.out.printf("\n String dividida em elementos do vetor: \n 1- %s \n 2- %s \n 3- %s \n", word1, word2, word3);
		

		System.out.printf("\n ---------------------------- \n");

		
		String s01 = original.toLowerCase();
		String s02 = original.toUpperCase();
		String s03 = original.trim();
		String s04 = original.substring(2);
		String s05 = original.substring(2, 9);
		String s06 = original.replace('a', 'x');
		String s07 = original.replace("abc", "xy");
		int i = original.indexOf("bc");
		int j = original.lastIndexOf("bc");
		System.out.println("Original: -" + original + "-");
		System.out.println("toLowerCase: -" + s01 + "-");
		System.out.println("toUpperCase: -" + s02 + "-");
		System.out.println("trim: -" + s03 + "-");
		System.out.println("substring(2): -" + s04 + "-");
		System.out.println("substring(2, 9): -" + s05 + "-");
		System.out.println("replace('a', 'x'): -" + s06 + "-");
		System.out.println("replace('abc', 'xy'): -" + s07 + "-");
		System.out.println("Index of 'bc': " + i);
		System.out.println("Last index of 'bc': " + j);
	}
}




