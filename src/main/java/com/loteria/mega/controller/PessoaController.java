package com.loteria.mega.controller;

import com.loteria.mega.DTO.PessoaResponseDTO;
import com.loteria.mega.exception.PessoaNaoEncontrada;
import com.loteria.mega.model.Pessoa;
import com.loteria.mega.repositories.PessoaRepository;
import com.loteria.mega.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPessoa(@PathVariable Long id){

		Pessoa pessoa = pessoaRepository.findById(id);

		if (pessoa == null) {
			throw new PessoaNaoEncontrada(id);
		}

		return new ResponseEntity<>(PessoaResponseDTO.toDTO(pessoa), HttpStatus.FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirPessoa(@PathVariable Long id){

		Pessoa pessoa = pessoaRepository.findById(id);

		if (pessoa == null) {
			throw new PessoaNaoEncontrada(id);
		}

		pessoaService.remover(pessoa);

		return new ResponseEntity<>(PessoaResponseDTO.toDTO(pessoa), HttpStatus.FOUND);
	}


}
