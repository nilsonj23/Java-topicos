package nisonj_ProjetoMongo.dto;

import java.io.Serializable;

import nisonj_ProjetoMongo.domain.User;

public class AuthorDTO implements Serializable {
	
	// ATRIBUTOS
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	// CONSTRUTORES
	public AuthorDTO() {
	}

	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}
	
	//GET e SET
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}