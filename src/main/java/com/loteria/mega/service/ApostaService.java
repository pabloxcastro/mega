package com.loteria.mega.service;

import com.loteria.mega.exception.PessoaPossuiApostas;
import com.loteria.mega.model.Aposta;
import com.loteria.mega.model.Pessoa;
import com.loteria.mega.repositories.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.loteria.mega.service.Numeros.sortear;

@Service
public class ApostaService {

    @Autowired
    private ApostaRepository apostaRepository;

    public Aposta salvar(Pessoa pessoa) {

        Aposta aposta = new Aposta();
        aposta.setPessoa(pessoa);
        aposta.setNumero(sortear());
        return apostaRepository.save(aposta);
    }

    public Integer remover(Pessoa pessoa){

        ArrayList<Aposta> apostas = apostaRepository.findByPessoaEquals(pessoa);

        Integer qtdApostas = apostas.size();

        apostaRepository.deleteAll(apostas);

        return qtdApostas;
    }


}
