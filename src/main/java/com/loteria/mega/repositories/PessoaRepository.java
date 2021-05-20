package com.loteria.mega.repositories;

import org.springframework.data.repository.CrudRepository;

import com.loteria.mega.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {
	
	Pessoa findByEmailEquals(String email);
	Pessoa findById(Long id);
}
