package com.mycompany.excecaopersonalizada;

public class IdadeInvalidaException extends Exception {

    private int idade;

    public IdadeInvalidaException(String message) {
        super(message);
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Uma pessoa de " + this.idade + " é menor de 18 anos";
    }

}
