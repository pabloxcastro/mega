package com.loteria.mega.DTO;

import com.loteria.mega.model.Aposta;
import com.loteria.mega.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApostaResponseDTO {
    private String numero;
    private String email;

    public static ApostaResponseDTO toDTO(Aposta aposta) {
        return new ApostaResponseDTO(aposta.getNumero(), aposta.getPessoa().getEmail());
    }



}
