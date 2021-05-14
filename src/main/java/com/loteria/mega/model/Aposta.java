package com.loteria.mega.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

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
		super();
	}

	public void setNumero(String numero) {this.numero = numero;}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public Pessoa getPessoa() {return pessoa;}
	public void setPessoa(Pessoa pessoa) {this.pessoa = pessoa;}
	public String getNumero() {return numero;}

	
}
