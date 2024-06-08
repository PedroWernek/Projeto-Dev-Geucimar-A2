package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.modelos.Comandante;
import br.edu.up.modelos.Pessoa;
import br.edu.up.util.Prompt;

public class GerenciadorDeArquivosComandante {

  public String headerCom = "";
  public String nomeArquivo = "C:/Users/user/Desktop/Projeto A2 - Geucimar/src/br/edu/up/docs/comandantes.csv";

  public List<Pessoa> getComandantes() {

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
        int idAeronautica = Integer.parseInt(dados[2]);
        int idMatricula = Integer.parseInt(dados[3]);

        Pessoa comandante = new Comandante(nome, rg, idAeronautica, idMatricula, idMatricula);
        listaDeComandantes.add(comandante);
      }

      leitor.close();

    } catch (FileNotFoundException e) {
      Prompt.imprimir("Arquivo de Comandantes não Encontrado!");
    }
    return listaDeComandantes;
  }

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
