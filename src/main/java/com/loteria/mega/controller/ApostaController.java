package com.loteria.mega.controller;
import javax.validation.Valid;

import com.loteria.mega.DTO.ApostaResponseDTO;
import com.loteria.mega.service.ApostaService;
import com.loteria.mega.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.loteria.mega.model.Aposta;
import com.loteria.mega.model.Pessoa;
import com.loteria.mega.repositories.ApostaRepository;
import com.loteria.mega.repositories.PessoaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ResponseEntity<?> createAposta(@RequestBody @Valid Pessoa pessoa){

		Pessoa pessoaNova = pessoaService.salvar(pessoa);
		Aposta aposta = apostaService.salvar(pessoaNova);

		return new ResponseEntity<>(ApostaResponseDTO.toDTO(aposta), HttpStatus.CREATED);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {

		Map <String, String> errors = new HashMap<>();

		exception.getBindingResult().getFieldErrors().
				forEach(error->errors.put(error.getField(), error.getDefaultMessage()));

		return errors;
	}


	@GetMapping("/{email}")
	public ResponseEntity<?> listarApostas(@PathVariable String email) {

		Pessoa pessoaExiste = pessoaRepository.findByEmailEquals(email);

		try {
			if (pessoaExiste == null) {
				throw new Exception(String.format("Email %s não encontrado", email));
			} else {

				ArrayList<Aposta> apostas = apostaRepository.findByPessoaEquals(pessoaExiste);

				List<ApostaResponseDTO> apostasDTO = new ArrayList<>();

				for (Aposta aposta : apostas) {
					ApostaResponseDTO apostaResponseDTO = ApostaResponseDTO.toDTO(aposta);
					apostasDTO.add(apostaResponseDTO);
				}

				return ResponseEntity.ok(apostasDTO);
			}
		} catch (Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
