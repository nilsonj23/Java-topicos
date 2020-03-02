package entidades;

public class Produto {
	private String nome;
	private Double preco;
	private Integer qtd;
	
	// CONSTRUTOR
	public Produto() {
	}

	public Produto(String nome, Double preco, Integer qtd) {
		this.nome = nome;
		this.preco = preco;
		this.qtd = qtd;
	}
	
	// GET e SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	
	// METODO
	public Double total() {
		return preco * qtd;
	}
}
