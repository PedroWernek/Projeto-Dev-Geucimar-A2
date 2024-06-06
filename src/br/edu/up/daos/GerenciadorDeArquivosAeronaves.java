package br.edu.up.daos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.modelos.Aeronave;

public class GerenciadorDeArquivosAeronaves {

    public List<Aeronave> getAeronaves() {
        List<Aeronave> listaDeAeronaves = new ArrayList<>();
        Aeronave aeronave = new Aeronave();
        
        aeronave.setIdCodigo(10);
        aeronave.setQtdAssentos(200);
        aeronave.setTipo("Boeing");
        
        listaDeAeronaves.add(aeronave);

        return listaDeAeronaves;
        
    }

    public boolean gravar(List<Aeronave> aeronaves) {
        try {
            FileWriter arquivoGravar = new FileWriter("E:\\Projeto A2 - Geucimar\\Projeto-Engenharia-de-Software---sistema-de-trafego-aereo\\src\\br\\edu\\up\\docs");
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println("Ola");

            gravador.close();
            return true;

        } catch(IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
        
        return false;
    }
    
}
