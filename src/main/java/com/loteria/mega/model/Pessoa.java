package com.loteria.mega.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Pessoa {

	@Id
	@Email(message = "Email inválido")
	@NotBlank(message = "Email não pode ser em branco ou nulo")
	private String email;

	public Pessoa(String email) {
		this.email = email;
	}

	public Pessoa(){
		//
	}

	public String getEmail() {return email;	}

}
