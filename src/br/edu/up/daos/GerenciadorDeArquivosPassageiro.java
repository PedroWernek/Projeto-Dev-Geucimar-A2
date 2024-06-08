package br.edu.up.daos;

import java.io.File;
import java.util.*;
import br.edu.up.modelos.Passageiro;

public class GerenciadorDeArquivosPassageiro {
    
    public String header = "";
    private String nomeDoArquivo = "teste";

    /* lê os arquivos */
    public List<Passageiro> getPassageiro() {
        List<Passageiro> listaDePassageiros = new ArrayList<>();

        try {
            File arquivoDeLeitura = new File(nomeDoArquivo);
        }
    }
}
