package com.loteria.mega.controller;

import javax.validation.Valid;

import com.loteria.mega.DTO.ApostaResponseDTO;
import com.loteria.mega.DTO.PessoaDTO;
import com.loteria.mega.service.ApostaService;
import com.loteria.mega.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.loteria.mega.model.Aposta;
import com.loteria.mega.model.Pessoa;
import com.loteria.mega.repositories.ApostaRepository;
import com.loteria.mega.repositories.PessoaRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/aposta")
public class ApostaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ApostaRepository apostaRepository;

	@Autowired
	private ApostaService apostaService;
	
	@PostMapping
	public ResponseEntity<ApostaResponseDTO> createAposta(@RequestBody @Valid PessoaDTO dto) {

		Pessoa pessoa = pessoaService.salvar(dto.transformaParaObjeto());
		Aposta aposta = apostaService.salvar(pessoa);

		return new ResponseEntity<>(ApostaResponseDTO.toDTO(aposta), HttpStatus.CREATED);
	}

	@GetMapping("/{email}")
	public List<ApostaResponseDTO> listarApostas(@PathVariable String email) {

		Pessoa pessoaExiste = pessoaRepository.findByEmailEquals(email);
		
		if (pessoaExiste == null) {
			return null;
		} else {

			ArrayList<Aposta> apostas = apostaRepository.findByPessoaEquals(pessoaExiste);

			List<ApostaResponseDTO> apostasDTO = new ArrayList<>();

			for (Aposta aposta : apostas) {
				ApostaResponseDTO apostaResponseDTO = ApostaResponseDTO.toDTO(aposta);
				apostasDTO.add(apostaResponseDTO);
			}

			return apostasDTO;
		}
	}
}
