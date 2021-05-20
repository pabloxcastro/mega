package com.loteria.mega.DTO;

import com.loteria.mega.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PessoaResponseDTO {
    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;

    public static PessoaResponseDTO toDTO(Pessoa pessoa) {

        return new PessoaResponseDTO(pessoa.getNome(), pessoa.getCpf(),
                pessoa.getEmail(), pessoa.getDataNascimento());
    }

}
