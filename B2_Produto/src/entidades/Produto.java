package entidades;

public class Produto {
	public String nome;
	public double preco;
	public int qtd;
	
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
