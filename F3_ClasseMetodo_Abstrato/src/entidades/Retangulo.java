package entidades;

import entidades.enums.Cor;

public class Retangulo extends Figura{
	private Double largura;
	private Double altura;
	
	// CONTRUTOR
	public Retangulo() {
		super();
	}
	
	public Retangulo(Cor cor, Double largura, Double altura) {
		super(cor);
		this.largura = largura;
		this.altura = altura;
	}
	
	// GET e SET
	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	} 	
	
	//METODO
	@Override
	public double area() {
		return largura * altura;
	}
}