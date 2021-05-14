package com.loteria.mega.DTO;

import com.loteria.mega.model.Pessoa;

public class PessoaDTO {

    private String email;

    private PessoaDTO(String email) {
    }
    private PessoaDTO() {
    }


    public Pessoa transformaParaObjeto() {
        return new Pessoa(this.email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
