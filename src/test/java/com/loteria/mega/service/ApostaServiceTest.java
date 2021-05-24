package com.loteria.mega.service;

import com.loteria.mega.model.Aposta;
import com.loteria.mega.model.Pessoa;
import com.loteria.mega.repositories.ApostaRepository;
import com.loteria.mega.repositories.PessoaRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApostaServiceTest {

    @Autowired
    private ApostaService apostaService;

    @Autowired
    private ApostaRepository apostaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    private Pessoa pessoa;

    @Before
    public void CreatePessoa(){
        pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setEmail("pessoa@email.com");
        pessoa.setCpf("75301676180");
        pessoa.setNome("José Maria");
        pessoa.setDataNascimento("31/01/1990");
        pessoaRepository.save(pessoa);
    }

    @Test
    public void salvar() {
        Aposta aposta = new Aposta();
        aposta.setPessoa(pessoa);
        aposta.setNumero("01,02,03,04,05,06");
        aposta = apostaRepository.save(aposta);
        Assertions.assertThat(aposta.getNumero()).isEqualTo("01,02,03,04,05,06");
    }

}
