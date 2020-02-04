package curso;

public class E_SplitString {

	public static void main(String[] args) {
		String entrada;
		String[] vet;
		
		entrada = "azul amarelo vermelho";
		vet = entrada.split(" ");
		
		System.out.println(vet[0]);
		System.out.println(vet[1]);
		System.out.println(vet[2]);
	}

}
