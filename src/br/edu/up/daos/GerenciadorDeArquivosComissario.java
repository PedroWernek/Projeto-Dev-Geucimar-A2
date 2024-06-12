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

import br.edu.up.modelos.Comissario;
import br.edu.up.modelos.Pessoa;
import br.edu.up.util.Prompt;


public class GerenciadorDeArquivosComissario {
    
  public String headerComissario = "";
  public String nomeDoArquivoComissario;
  
  public GerenciadorDeArquivosComissario() {
        Path caminhoRelativoComissario = Paths.get("src", "br", "edu", "up", "docs", "comissarios.csv");
        nomeDoArquivoComissario = caminhoRelativoComissario.toAbsolutePath().toString();
    }

  public List<Pessoa> getComissario() {
    
    List<Pessoa> listaComissario = new ArrayList<>();

    try {
      File arquivoComissario = new File(nomeDoArquivoComissario);
      Scanner leitorComissario = new Scanner(arquivoComissario);

      headerComissario = leitorComissario.nextLine();

      while (leitorComissario.hasNextLine()) {
        String linhaAtualComissario = leitorComissario.nextLine();
        String[] dadosComissario = linhaAtualComissario.split(";");

        String nome = dadosComissario[0];
        String rg = dadosComissario[1];
        int idAeronautica = Integer.parseInt(dadosComissario[2]);
        int idMatricula = Integer.parseInt(dadosComissario[3]);

        Comissario comissario = new Comissario(nome, rg, idAeronautica, idMatricula, rg);
        listaComissario.add(comissario);
      }

      leitorComissario.close();

    } catch (FileNotFoundException e) {
      Prompt.imprimir("Arquivo de Comissarios não Encontrado!");
    }
    return listaComissario;
  }
    
  public boolean gravar(List<Pessoa> listaComissario) {

    try {
      FileWriter arquivoGravarComissario = new FileWriter(nomeDoArquivoComissario);
      PrintWriter gravadorComissario = new PrintWriter(arquivoGravarComissario);

      gravadorComissario.println(headerComissario);

      for (Pessoa comissarios : listaComissario) {
        gravadorComissario.println(comissarios.toCSV());
      }

      gravadorComissario.close();
      return true;
    } catch (IOException e) {
      
    }

    return false;
  }
}
