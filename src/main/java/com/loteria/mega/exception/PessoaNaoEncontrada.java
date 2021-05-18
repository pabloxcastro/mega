package com.loteria.mega.exception;

public class PessoaNaoEncontrada extends RuntimeException {

    public PessoaNaoEncontrada (String email) {
        super(String.format("Email %s não encontrado", email));
    }
}
