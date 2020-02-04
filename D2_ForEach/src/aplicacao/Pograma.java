package aplicacao;

public class Pograma {

	public static void main(String[] args) {
		String[] vet = new String[] {"Maria", "João", "José"};
		
		for(int i=0; i<vet.length; i++) {
			System.out.println(vet[i]);
		}
		
		System.out.println("----------");
		
		for(String obj : vet) {
			System.out.println(obj);
		}
	}
}