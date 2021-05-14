package com.loteria.mega.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Pessoa pessoa;
	
	@Column
	private String numero;

	public Aposta(String numero, Pessoa pessoa) {
		this.numero = numero;
		this.pessoa = pessoa;
	}
	public Aposta() {
		//
	}

	public void setNumero(String numero) {this.numero = numero;}
	public Pessoa getPessoa() {return pessoa;}
	public void setPessoa(Pessoa pessoa) {this.pessoa = pessoa;}
	public String getNumero() {return numero;}

	
}
