package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.modelos.Aeronave;

public class GerenciadorDeArquivosAeronaves {

    public String header;

    public List<Aeronave> getAeronaves() {
        List<Aeronave> listaDeAeronaves = new ArrayList<>();
       
        try {
            File arquivoLeitura = new File("E:\\Projeto A2 - Geucimar\\Projeto-Engenharia-de-Software---sistema-de-trafego-aereo\\src\\br\\edu\\up\\docs\\aeronaves.csv");
            Scanner leitor = new Scanner(arquivoLeitura);

            header = leitor.nextLine();
            
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dadosAeronave = linha.split(";");

                int idCodigo = Integer.parseInt(dadosAeronave[0]);
                int qtdAssentos = Integer.parseInt(dadosAeronave[1]);
                String idTipo = dadosAeronave[2];

                Aeronave aeronave = new Aeronave();

                aeronave.setIdCodigo(idCodigo);
                aeronave.setQtdAssentos(qtdAssentos);
                aeronave.setTipo(idTipo);

                
                listaDeAeronaves.add(aeronave);

            }
        
        } catch(FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        }

        return listaDeAeronaves;
    }

    public boolean gravar(List<Aeronave> aeronaves) {
        try {
            FileWriter arquivoGravar = new FileWriter("E:\\Projeto A2 - Geucimar\\Projeto-Engenharia-de-Software---sistema-de-trafego-aereo\\src\\br\\edu\\up\\docs\\aeronaves.csv");
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            
            gravador.println(header);

            for (Aeronave aeronave : aeronaves) {
                gravador.println(aeronave.toString());
            }

            gravador.close();
            return true;

        } catch(IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
        
        return false;
    }
    
}
