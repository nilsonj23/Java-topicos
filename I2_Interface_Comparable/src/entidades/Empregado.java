package entidades;

public class Empregado implements Comparable<Empregado>{
	private String nome;
	private Double salario;
	
	// CONSTRUTOR
	public Empregado() {
	}
	public Empregado(String nome, Double salario) {
		this.nome = nome;
		this.salario = salario;
	}

	// GET e SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	// METODO
	@Override
	public int compareTo(Empregado outro) {
		//return nome.compareTo(outro.getNome());
		//return salario.compareTo(outro.getSalario());
		return -salario.compareTo(outro.getSalario());
	}
}
