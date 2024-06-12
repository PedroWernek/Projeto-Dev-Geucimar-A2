package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.modelos.Aeronave;

public class GerenciadorDeArquivosAeronaves {

    public String headerAeronave;
    public String nomeDoArquivoAeronaves;

    public GerenciadorDeArquivosAeronaves() {
        Path caminhoArquivoComandante = Paths.get("src", "br", "edu", "up", "docs", "aeronaves.csv");
        nomeDoArquivoAeronaves = caminhoArquivoComandante.toAbsolutePath().toString();
    }

    public List<Aeronave> getAeronaves() {
        List<Aeronave> listaDeAeronaves = new ArrayList<>();

        try {
            /*
             * toda a vez que alguém precisar
             * mudar o caminho comenta ele pra não precisar
             * ficar reescrevendo - Pedro
             */
            File arquivoLeituraAeronaves = new File(nomeDoArquivoAeronaves);
            Scanner leitorAeronaves = new Scanner(arquivoLeituraAeronaves);

            headerAeronave = leitorAeronaves.nextLine();

            while (leitorAeronaves.hasNextLine()) {
                String linhaAeronaves = leitorAeronaves.nextLine();
                String[] dadosAeronave = linhaAeronaves.split(";");

                int idCodigo = Integer.parseInt(dadosAeronave[0]);
                int qtdAssentos = Integer.parseInt(dadosAeronave[1]);
                String idTipo = dadosAeronave[2];

                Aeronave aeronave = new Aeronave();

                aeronave.setIdCodigo(idCodigo);
                aeronave.setQtdAssentos(qtdAssentos);
                aeronave.setTipo(idTipo);

                listaDeAeronaves.add(aeronave);

            }

            leitorAeronaves.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        }

        return listaDeAeronaves;
    }

    public boolean gravar(List<Aeronave> aeronaves) {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivoAeronaves);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(headerAeronave);

            for (Aeronave aeronave : aeronaves) {
                gravador.println(aeronave.toString());
            }

            gravador.close();
            return true;

        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }

        return false;
    }

}
