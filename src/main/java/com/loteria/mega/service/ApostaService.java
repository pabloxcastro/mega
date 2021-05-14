package com.loteria.mega.service;

import com.loteria.mega.model.Aposta;
import com.loteria.mega.model.Pessoa;
import com.loteria.mega.repositories.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ApostaService {

    @Autowired
    private ApostaRepository apostaRepository;

    public Aposta salvar(Pessoa pessoa) {

        Aposta aposta = new Aposta();
        aposta.setPessoa(pessoa);
        aposta.setNumero(sortearNumeros());
        return apostaRepository.save(aposta);
    }

    private String sortearNumeros(){

        ArrayList<Integer> listaNumero;
        listaNumero = new ArrayList<>();

        Random numerosSorteados = new Random();

        for (int n = 0; n < 6; ) {
            Integer dezena = numerosSorteados.nextInt(60) + 1;
            if (!listaNumero.contains(dezena)) {
                listaNumero.add(dezena);
                n++;
            }
        }
        Collections.sort(listaNumero);

        return listaNumero.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
