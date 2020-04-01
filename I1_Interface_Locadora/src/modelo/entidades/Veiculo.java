package modelo.entidades;

public class Veiculo {
	private String modelo;
	
	// CONSTRUTOR
	public Veiculo() {
	}
	public Veiculo(String modelo) {
		this.modelo = modelo;
	}
	
	// GET e SET
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
