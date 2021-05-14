package com.loteria.mega.repositories;

import com.loteria.mega.model.Aposta;
import com.loteria.mega.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ApostaRepository extends CrudRepository<Aposta, Integer> {

	ArrayList<Aposta> findByPessoaEquals(Pessoa pessoa);
}
