package com.loteria.mega.model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Pessoa {

	@Id
	@Email
	private String email;

	public Pessoa(String email) {
		this.email = email;
	}

	public Pessoa(){
		//
	}

	public String getEmail() {return email;	}

	public void setEmail(String email) {this.email = email;	}
	
}
