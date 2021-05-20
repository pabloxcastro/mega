package com.loteria.mega.exception;

public class PessoaPossuiApostas extends RuntimeException{

    public PessoaPossuiApostas() {
        super("Pessoa possui apostas não pode ser excluída");
    }

}
