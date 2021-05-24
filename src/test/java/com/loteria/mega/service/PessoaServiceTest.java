package com.loteria.mega.service;

import com.loteria.mega.model.Pessoa;
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
public class PessoaServiceTest {

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
    }

    @Test
    public void Salvar() {
        Pessoa pessoa1 = pessoaService.salvar(pessoa);
        Assertions.assertThat(pessoa1.getEmail()).isEqualTo("pessoa@email.com");
        Assertions.assertThat(pessoa1.getCpf()).isEqualTo("75301676180");
        Assertions.assertThat(pessoa1.getNome()).isEqualTo("José Maria");
        Assertions.assertThat(pessoa1.getDataNascimento()).isEqualTo("31/01/1990");
    }

    @Test
    public void Remover(){
        pessoaRepository.delete(pessoa);
    }


}
