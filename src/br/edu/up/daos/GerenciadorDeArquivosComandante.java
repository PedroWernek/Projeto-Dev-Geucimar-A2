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

import br.edu.up.modelos.Comandante;
import br.edu.up.modelos.Pessoa;
import br.edu.up.util.Prompt;

public class GerenciadorDeArquivosComandante {

  public String headerCom = "";
  public String nomeArquivo;
  
  public GerenciadorDeArquivosComandante(){
    Path caminhoArquivo = Paths.get("src", "br", "edu", "up", "docs", "comandantes.csv");
    nomeArquivo = caminhoArquivo.toAbsolutePath().toString();
  }
  public List<Pessoa> getComandantes() {
    /**
     * Aqui estou pegando todos os Comandantes
     * do arquivo "comandantes.csv"
     */
    List<Pessoa> listaDeComandantes = new ArrayList<>();

    try {
      File arquivo = new File(nomeArquivo);
      Scanner leitor = new Scanner(arquivo);

      headerCom = leitor.nextLine();

      while (leitor.hasNextLine()) {
        String linhaAtual = leitor.nextLine();
        String[] dados = linhaAtual.split(";");

        String nome = dados[0];
        String rg = dados[1];
        double idAeronautica = Double.parseDouble(dados[2]);
        double idMatricula = Double.parseDouble(dados[3]);
        int totalHorasVoo = Integer.parseInt(dados[4]);

        Pessoa comandante = new Comandante(nome, rg, idAeronautica, idMatricula, totalHorasVoo);
        listaDeComandantes.add(comandante);
      }

      leitor.close();

    } catch (FileNotFoundException e) {
      Prompt.imprimir("Arquivo de Comandantes não Encontrado!");
    }
    return listaDeComandantes;
  }
    /**
     * Aqui estou gravando todos os Comandantes
     * do da lista "comandantes"
     * no arquivo "comandantes.csv"
     * e esperando um sinal TRUE na função
     */
  public boolean gravar(List<Pessoa> listaComandantes) {

    try {
      FileWriter arquivoGravar = new FileWriter(nomeArquivo);
      PrintWriter gravador = new PrintWriter(arquivoGravar);

      gravador.println(headerCom);

      for (Pessoa comandante : listaComandantes) {
        gravador.println(comandante.toCSV());
      }

      gravador.close();
      return true;
    } catch (IOException e) {
      
    }

    return false;
  }

}
