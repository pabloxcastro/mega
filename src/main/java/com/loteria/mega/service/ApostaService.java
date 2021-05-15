package com.loteria.mega.service;

import com.loteria.mega.model.Aposta;
import com.loteria.mega.model.Pessoa;
import com.loteria.mega.repositories.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.loteria.mega.service.Numeros.*;

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


}
