package entidades;

import entidades.enums.Cor;

public class Circulo extends Figura{
	private Double raio;
	
	// CONSTRUTOR
	public Circulo() {
		super();
	}
	public Circulo(Cor cor, Double raio) {
		super(cor);
		this.raio = raio;
	}
	
	// GET e SET
	public Double getRaio() {
		return raio;
	}
	public void setRaio(Double raio) {
		this.raio = raio;
	}
	
	// METODO
	@Override
	public double area() {
		return raio * raio * Math.PI;
	}
}