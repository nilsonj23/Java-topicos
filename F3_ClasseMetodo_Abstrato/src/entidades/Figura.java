package entidades;

import entidades.enums.Cor;

public abstract class Figura { 		// Classe abstrata - Não pode ser instanciada mas é muito útil para fazer operações com as subclasses de forma rápida
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
