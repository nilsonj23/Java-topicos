package modelo.servicos;

import modelo.entidades.AluguelCarros;
import modelo.entidades.Fatura;

public class ServicoAluguel {
	private Double precoDia;
	private Double precoHora;
	
	private TaxaServico taxaServico;

	// CONSTRUTOR
	public ServicoAluguel(Double precoDia, Double precoHora, TaxaServico taxaServico) {
		this.precoDia = precoDia;
		this.precoHora = precoHora;
		this.taxaServico = taxaServico;
	}
	
	// METODO
	public void ProcessarFatura(AluguelCarros aluguelCarros) {
		long tempo1 = aluguelCarros.getInicio().getTime();
		long tempo2 = aluguelCarros.getFim().getTime();
		double horas = (double)(tempo2 - tempo1) / 1000 / 60 / 60;
		
		double pagamentoBasico;
		if (horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoHora;
			System.out.println(pagamentoBasico);
		}
		else {
			pagamentoBasico = Math.ceil(horas / 24) * precoDia;
		}
		
		double taxa = taxaServico.taxa(pagamentoBasico);
		
		aluguelCarros.setFatura(new Fatura(pagamentoBasico, taxa));
	}
}
