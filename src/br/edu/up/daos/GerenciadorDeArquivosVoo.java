package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.up.util.Prompt;

import br.edu.up.modelos.Voo;

public class GerenciadorDeArquivosVoo {
    
    public String header = "";
    private String nomeDoArquivo;

    public List<Voo> getVoos(){
        List<Voo> listaVoos = new ArrayList();

        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);

            header = leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dadosVoo = linha.split(";");

                String aeronave = dadosVoo[0];
                String idVoo = dadosVoo[1];
                String origem = dadosVoo[2];
                String destino = dadosVoo[3];
                String comandante = dadosVoo[4];
                String comissario = dadosVoo[5];
                String passageiro = dadosVoo[6];
                String dataVoo = dadosVoo[7];
                String qtdAssentosDisponiveis = dadosVoo[8];

                Voo Voos = new Voo(aeronave, idVoo, origem, destino, comandante, comissario, passageiro, dataVoo, qtdAssentosDisponiveis);
                
                listaVoos.add(Voos);

                leitor.close();
            }
        } catch (FileNotFoundException e) {
            Prompt.imprimir("Arquivo não encontrado!");
        } return listaVoos;
    }

    public boolean gravar(List<Voo> voos){
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);

            for (Voo voo : voos){
                gravador.println(voo.toCSV());
            }
            gravador.close();
            return true;

        } catch (IOException e) {
            Prompt.imprimir("Não foi possível gravar o arquivo!");
        }
        return false;
    }

}
