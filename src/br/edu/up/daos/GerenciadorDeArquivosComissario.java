package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.modelos.Comissario;
import br.edu.up.modelos.Pessoa;
import br.edu.up.util.Prompt;


public class GerenciadorDeArquivosComissario {
    
  public String headerCom = "";
  public String nomeArquivo = "C:/Users/user/Desktop/Projeto A2 - Geucimar/src/br/edu/up/docs/comissarios.csv";

  public List<Pessoa> getComissario() {
    
    List<Pessoa> listaComissario = new ArrayList<>();

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

        Comissario comissario = new Comissario(nome, rg, idAeronautica, idMatricula, rg);
        listaComissario.add(comissario);
      }

      leitor.close();

    } catch (FileNotFoundException e) {
      Prompt.imprimir("Arquivo de Comissarios não Encontrado!");
    }
    return listaComissario;
  }
    
  public boolean gravar(List<Pessoa> listaComissario) {

    try {
      FileWriter arquivoGravar = new FileWriter(nomeArquivo);
      PrintWriter gravador = new PrintWriter(arquivoGravar);

      gravador.println(headerCom);

      for (Pessoa comissarios : listaComissario) {
        gravador.println(comissarios.toCSV());
      }

      gravador.close();
      return true;
    } catch (IOException e) {
      
    }

    return false;
  }
}
