package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.AluguelCarros;
import modelo.entidades.Veiculo;
import modelo.servicos.ServicoAluguel;
import modelo.servicos.ServicoTaxaBrasil;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com a data de aluguel");
		System.out.print("Modelo do carro: ");
		String modelo = entrada.nextLine();
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		Date inicio = sdf.parse(entrada.nextLine());
		System.out.print("Entrega (dd/MM/yyyy hh:mm): ");
		Date fim = sdf.parse(entrada.nextLine());
		
		AluguelCarros ac = new AluguelCarros(inicio, fim, new Veiculo(modelo));
		
		System.out.print("Entre com preço por hora: ");
		double precoHora = entrada.nextDouble();
		System.out.print("Entre com preço por dia: ");
		double precoDia = entrada.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoDia, precoHora, new ServicoTaxaBrasil());
		servicoAluguel.ProcessarFatura(ac);
		
		System.out.println("FATURA:");
		System.out.println("Pagamento básico: " + String.format("%.2f", ac.getFatura().getPagBasico()));
		System.out.println("Taxa: " + String.format("%.2f", ac.getFatura().getTaxa()));
		System.out.println("Pagamento total: " + String.format("%.2f", ac.getFatura().getPagTotal()));
		
		entrada.close();
	}
}