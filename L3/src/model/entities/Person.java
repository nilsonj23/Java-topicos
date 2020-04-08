package model.entities;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String email;
	
	// CONSTRUTOR
	public Person() {
	}
	public Person(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	// GET e SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Person [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
	
}
