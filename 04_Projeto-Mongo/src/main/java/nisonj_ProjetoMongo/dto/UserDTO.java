package nisonj_ProjetoMongo.dto;

import java.io.Serializable;

import nisonj_ProjetoMongo.domain.User;

public class UserDTO implements Serializable {
	
	// ATRIBUTOS
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;

	// CONSTRUTORES
	public UserDTO() {
	}

	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	// GET e SET
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}