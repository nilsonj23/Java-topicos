package entidades;

public class Produto {
	private String nome;
	private double preco;
	
	// CONSTRUTORES	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	// GET e SET
	public String getNome() {
		return nome; 
	}
	
	public void setNome(String nome) {
		this.nome = nome; 
	}
	
	public double getPreco() {
		return preco; 
	}
	
	public void setPreco(double preco) {
		this.preco = preco; 
	}
	
	// METODOS
	/*
	public double totalValorEmEstoque() {
		return preco * qtd;
	}
	
	public void adiconarProdutos(int qtd) {
		this.qtd += qtd;
	}
	
	public void removerProdutos(int qtd) {
		this.qtd -= qtd;
	}
	
	public String toString() {
		return nome + ", R$: " + String.format("%.2f", preco) + ", " + qtd + 
				" unidades, Total R$: " + String.format("%.2f", totalValorEmEstoque());
	}*/
}
