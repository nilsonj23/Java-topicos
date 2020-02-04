package aplicacao;

public class Arg {

	public static void main(String[] args) {
		//verifica se foi passado 2 argumentos
		if(args.length==2) {
			double a = Double.parseDouble(args[0]);
			double b = Double.parseDouble(args[1]);
			double area = a * b;
			System.out.println("Area = " + area);
		}
	}
}
	