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

  public String headerComandante = "";
  public String nomeArquivoComandante;
  
  public GerenciadorDeArquivosComandante(){
    Path caminhoArquivoComandante = Paths.get("src", "br", "edu", "up", "docs", "comandantes.csv");
    nomeArquivoComandante = caminhoArquivoComandante.toAbsolutePath().toString();
  }
  public List<Pessoa> getComandantes() {
    /**
     * Aqui estou pegando todos os Comandantes
     * do arquivo "comandantes.csv"
     */
    List<Pessoa> listaDeComandantes = new ArrayList<>();

    try {
      File arquivoComandante = new File(nomeArquivoComandante);
      Scanner leitorComandante = new Scanner(arquivoComandante);

      headerComandante = leitorComandante.nextLine();

      while (leitorComandante.hasNextLine()) {
        String linhaAtual = leitorComandante.nextLine();
        String[] dadosComandante = linhaAtual.split(";");

        String nome = dadosComandante[0];
        String rg = dadosComandante[1];
        double idAeronautica = Double.parseDouble(dadosComandante[2]);
        double idMatricula = Double.parseDouble(dadosComandante[3]);
        int totalHorasVoo = Integer.parseInt(dadosComandante[4]);

        Pessoa comandante = new Comandante(nome, rg, idAeronautica, idMatricula, totalHorasVoo);
        listaDeComandantes.add(comandante);
      }

      leitorComandante.close();

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
      FileWriter arquivoGravarComandante = new FileWriter(nomeArquivoComandante);
      PrintWriter gravadorComandante = new PrintWriter(arquivoGravarComandante);

      gravadorComandante.println(headerComandante);

      for (Pessoa comandante : listaComandantes) {
        gravadorComandante.println(comandante.toCSV());
      }

      gravadorComandante.close();
      return true;
    } catch (IOException e) {
      
    }

    return false;
  }

}
