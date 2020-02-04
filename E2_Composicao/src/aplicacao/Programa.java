package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat fDate = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = entrada.nextLine();
		
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = entrada.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = entrada.nextLine();
		System.out.print("Salario base: ");
		double salarioBase = entrada.nextDouble();
		
		// Instanciando o trabalhador
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos tem esse trabalhador: ");
		int qtd = entrada.nextInt();

		for (int i=0; i<qtd; i++) {
			System.out.println("Entre com os dados do "+ (i+1) + "# contrato: ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date data = fDate.parse(entrada.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = entrada.nextDouble();
			System.out.print("Duração (Horas): ");
			int hora = entrada.nextInt();
		
			// Instanciando o contrato
			ContratoHora contrato = new ContratoHora(data, valorPorHora, hora);	
			trabalhador.addContrato(contrato);	// adicionando o contrato ao trabalhador 
		}
		
		System.out.println();
		System.out.print("Entre com mês e ano para calcular a receita (MM/YYYY): ");
		String mesAno = entrada.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Receita para " + mesAno + ": " + String.format("%.2f", trabalhador.receita(ano, mes)));

		entrada.close();
	}
}