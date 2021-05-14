package com.loteria.mega.DTO;

import com.loteria.mega.model.Aposta;
import com.loteria.mega.model.Pessoa;

public class ApostaResponseDTO {
    private String numero;
    private Pessoa pessoa;

    public static ApostaResponseDTO toDTO(Aposta aposta) {
        return new ApostaResponseDTO(aposta.getNumero(), aposta.getPessoa());
    }

    public ApostaResponseDTO(String numero, Pessoa pessoa) {
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
