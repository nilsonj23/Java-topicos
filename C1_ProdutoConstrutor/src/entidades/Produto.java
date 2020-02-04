package entidades;

public class Produto {
	private String nome;
	private double preco;
	private int qtd;
	
	// CONSTRUTORES
	public Produto() {
	}
		
	public Produto(String nome, double preco, int qtd) {
		this.nome = nome;
		this.preco = preco;
		this.qtd = qtd;
	}
	
	public Produto(String n, double p) {
		nome = n;
		preco = p;
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
	
	public int getQtd() {
		return qtd; 
	}
	
	// METODOS
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
	}
}
