package com.mycompany.gestordereservas;

public class GestorDeReservas {
    
    public static void main(String[] args) {
        Passageiro passageiro1 = new Passageiro("João", "M", 23);
        Passageiro passageiro2 = new Passageiro("Maria", "F", 22);
        Voo voo1 = new Voo("João Pessoa", "Recife", 50);
        Voo voo2 = new Voo("João Pessoa", "Recife", 20);
        Passagem passagem1 = new Passagem(voo1, passageiro1, "A1");
        Passagem passagem2 = new Passagem(voo2, passageiro2, "A3");
        Passagem passagem3 = new Passagem(voo1, passageiro1, "A3");
        System.out.println(passageiro1);
        System.out.println(passageiro2);
        System.out.println(voo1.getReservas());
        System.out.println(voo2);
        System.out.println(passagem1);
        System.out.println(passagem2);
        System.out.println(passagem3);
        passagem3.cancelarReserva(passagem3.getIdReserva());
        voo1.listarReservas("Recife");
    }
}
