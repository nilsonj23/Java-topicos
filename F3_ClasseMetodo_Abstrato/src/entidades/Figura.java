package entidades;

import entidades.enums.Cor;

public abstract class Figura { 		// Classe abstrata - N�o pode ser instanciada mas � muito �til para fazer opera��es com as subclasses de forma r�pida
	private Cor cor;
	
	// CONSTRUTOR
	public Figura() {
	}
	public Figura(Cor cor) {
		this.cor = cor;
	}

	// GET e SET
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	// METODOS
	public abstract double area();
}
