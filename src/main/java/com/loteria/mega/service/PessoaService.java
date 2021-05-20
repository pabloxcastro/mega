package com.loteria.mega.service;

import com.loteria.mega.exception.PessoaPossuiApostas;
import com.loteria.mega.model.Pessoa;
import com.loteria.mega.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa ){

        Pessoa pessoaExiste = pessoaRepository.findByEmailEquals(pessoa.getEmail());

        if (pessoaExiste == null) {
            pessoa = pessoaRepository.save(pessoa);
        } else {
            pessoa = pessoaExiste;
        }
        return pessoa;
    }

    public void remover(Pessoa pessoa){
        try {
            pessoaRepository.delete(pessoa);

        } catch (DataIntegrityViolationException e) {
            throw new PessoaPossuiApostas();
        }
    }
}
