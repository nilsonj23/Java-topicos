package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import entidades.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	// Composicoes de objetos (associacoes)
	private Departamento departamento;							// O trabalhador possui somente um departamento
	private List<ContratoHora> contratos = new ArrayList<>(); 	// O trabalhador possui varios contratos
	
	// CONSTRUTOR
	public Trabalhador() {
	}
	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}
	
	// GET SET
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public NivelTrabalhador getNivel() {
		return nivel;
	}
	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<ContratoHora> getContratos() {
		return contratos;
	}
	
	// METODOS
	public void addContrato(ContratoHora contrato) {
		contratos.add(contrato);		
	}
	public void removerContrato(ContratoHora contrato) {
		contratos.remove(contrato);		
	}
	public Double receita(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		
		for (ContratoHora c : contratos) {
			cal.setTime(c.getDate());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1+ cal.get(Calendar.MONTH);
			
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}