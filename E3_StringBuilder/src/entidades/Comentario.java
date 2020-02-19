package entidades;

public class Comentario {
	private String texto;
	
	// CONSTRUTOR
	public Comentario() {
	}
	public Comentario(String texto) {
		this.texto = texto;
	}
	
	// GET SET
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}	
}
