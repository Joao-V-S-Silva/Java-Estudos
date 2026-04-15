package com.mycompany.arquivocomtratamento;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.Scanner;

public class ArquivoComTratamento {

    public static void main(String[] args) {
        try {
            Path diretorioArquivo = Paths.get("C:\\Users\\joaov\\OneDrive\\Documentos\\João\\Códigos\\Java\\Estudos\\Exceptions\\ArquivoComTratamento\\dados.txt");
            File arquivo = new File("C:\\Users\\joaoav\\OneDrive\\Documentos\\João\\Códigos\\Java\\Estudos\\Exceptions\\ArquivoComTratamento\\dados.txt");
            Scanner leitor = new Scanner(arquivo);
            System.out.println(Files.isReadable(diretorioArquivo));
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                System.out.println(linha);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("O arquivo especificado não foi encontrado, verifique !");
        }
    }
}
