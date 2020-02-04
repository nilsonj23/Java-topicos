package aplicacao;
import javax.swing.JOptionPane;
 
public class aplicacao {
 
    public static void main(String[] args) {
    	int m1, m2;
        int n = Integer.parseInt(JOptionPane.showInputDialog("Entre com o numero de vertices: "));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Entre com o numero de arestas:"));
        
        int mat[][] = new int[n][n];
        
		// Inicializando a matriz com 0
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				mat[i][j] = 0;
			}
		}
		
		// Inserindo 1 nas arestas inputadas
        for (int i = 0; i < m; i++) {
        	m1 = Integer.parseInt(JOptionPane.showInputDialog("Entre com o par X da arestas: ")) - 1;
        	m2 = Integer.parseInt(JOptionPane.showInputDialog("Entre com o par Y da arestas: ")) - 1;
    		mat[m1][m2] = 1;
    		mat[m2][m1] = 1;
           }
    
        //Imprimir matriz
        String resultado = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado += mat[i][j];
                resultado += "    ";
            }
            resultado += "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}

/*
package aplicacao;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		int aux, n, m, m1, m2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre 1 para carregar a matriz adjacente"); 
		System.out.println("Entre 2 para inserir uma nova matriz adjacente"); 
		aux = sc.nextInt();
		if (aux == 1) {
			// Carregar o arquivo
			System.out.println("Carregar o arquivo"); 

		} else if (aux == 2) {
		
			System.out.print("Entre com o Grafo = (V,E): "); 
			n = sc.nextInt();
			m = sc.nextInt();
			
			// Inicializando a matriz com 0
			int[][] mat = new int[n][n];
	
		for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					mat[i][j] = 0;
				}
			}
			
			// Inserindo 1 nas arestas inputadas
			System.out.println("Entre com o par X Y da arestas: "); 
			for (int i=0; i<m; i++) {
				m1 = sc.nextInt() - 1;
				m2 = sc.nextInt() - 1;
				mat[m1][m2] = 1;
				mat[m2][m1] = 1;
			}
			
			// Inprimindo a matriz adjacente
			for (int i=0; i<n; i++) {
				System.out.println(" "); 
				for (int j=0; j<n; j++) {
					System.out.print(mat[i][j] + " "); 
				}
			} 
		}
		
		sc.close();
	}
}
*/