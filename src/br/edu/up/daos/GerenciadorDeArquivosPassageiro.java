package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.*;
import br.edu.up.modelos.Passageiro;
import br.edu.up.modelos.Passagem;
import br.edu.up.util.Prompt;

public class GerenciadorDeArquivosPassageiro {
    
    public String headerPassageiro = "";
    private String nomeDoArquivo;

    /* encontra partes em comum do caminho já que os computadores tem caminhos diferentes */
    public GerenciadorDeArquivosPassageiro() {
        Path caminhoRelativo = Paths.get("src", "br", "edu", "up", "docs", "passageiros.csv");
        nomeDoArquivo = caminhoRelativo.toAbsolutePath().toString();
    }

    /* lê os arquivos */
    public List<Passageiro> getPassageiro() {
        List<Passageiro> listaDePassageiros = new ArrayList<>();

        try {
            File arquivoDeLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoDeLeitura);

            headerPassageiro = leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dadosPassageiros = linha.split(";");

                String nome = dadosPassageiros[0];
                String rg = dadosPassageiros[1];
                int idBagagem = Integer.parseInt(dadosPassageiros[2]);
                int idPassagem = Integer.parseInt(dadosPassageiros[3]);
                String assento = dadosPassageiros[4];

                Passagem passagem = new Passagem(idPassagem, assento);
                Passageiro passageiro = new Passageiro(nome, rg, passagem, idBagagem);
                listaDePassageiros.add(passageiro);

                leitor.close();
                /* verificar se é viável colocar voo */

            }
        } catch (FileNotFoundException e) {
                Prompt.imprimir("Arquivo não encontrado!");
            } 

            return listaDePassageiros;
        }

        public boolean gravar(List<Passageiro> passageiros) {
            try {
                FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
                PrintWriter gravador = new PrintWriter(arquivoGravar);

                gravador.println(headerPassageiro);

                for (Passageiro passageiro : passageiros) {
                    gravador.println(passageiro.toString());
                    /* toString ou toCSV? */
                }
                gravador.close();
                return true;
            } catch (IOException e) {
                Prompt.imprimir("Não foi possível gravar o arquivo!");
            }
            return false;
        }
    }
