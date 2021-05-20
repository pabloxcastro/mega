package com.loteria.mega.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CPF(message = "CPF Inválido")
	private String cpf;

	@Email(message = "Email inválido")
	@NotBlank(message = "Email não pode ser em branco ou nulo")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Nome não pode ser em branco ou nulo")
	private String Nome;

	@NotBlank(message = "Data de nascimento é obrigatório")
	private String dataNascimento;

}
