package entidades;

public class Departamento {
	private String nome;
	
	// CONSTRUTOR
	public Departamento() {
	}
	public Departamento(String nome) {
		this.nome = nome;
	}

	// GET SET
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
