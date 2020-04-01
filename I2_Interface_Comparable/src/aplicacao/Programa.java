package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Empregado;

public class Programa {
	public static void main(String[] args) {
		List<Empregado> lista = new ArrayList<>();
		String caminho = "A:\\Documentos\\Programação\\Java\\eclipse-workspace\\I2_Interface_Comparable\\src\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			String empregadoCsv = br.readLine();
			while (empregadoCsv != null) {
				String[] campos = empregadoCsv.split(",");
				lista.add(new Empregado(campos[0], Double.parseDouble(campos[1])));
				empregadoCsv = br.readLine();
			}
			Collections.sort(lista);
			for (Empregado emp : lista) {
				System.out.println(emp.getNome() + ", " + emp.getSalario());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}