package curso;

public class A_Conversao {

	public static void main(String[] args) {
		double a, res1, res2;
		int b, c;
		
		a = 5.7;
		b = (int)a;
		c = 2;
		res1 = (double) b / c;
		res2 = b / c;
		
		System.out.println("b = " + b);	  		//    b = 5
		System.out.println("res1 = " + res1);	// res1 = 2.5
		System.out.println("res2 = " + res2);	// res2 = 2.0
		
		//---------------------- Conversão de String ----------------------------
		int n1;
		double n2;
		String s = "33";
		
		n1 = Integer.parseInt(s);
		n2 = Double.parseDouble(s);
		
		System.out.println("n1 = " + n1);	// n1 = 33
		System.out.println("n2 = " + n2);	// n2 = 33.0
	}

}
