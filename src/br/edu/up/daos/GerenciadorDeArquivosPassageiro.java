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
    private String nomeDoArquivoPassageiro;

    /* encontra partes em comum do caminho já que os computadores tem caminhos diferentes */
    public GerenciadorDeArquivosPassageiro() {
        Path caminhoRelativoPassageiro = Paths.get("src", "br", "edu", "up", "docs", "passageiros.csv");
        nomeDoArquivoPassageiro = caminhoRelativoPassageiro.toAbsolutePath().toString();
    }

    /* lê os arquivos */
    public List<Passageiro> getPassageiro() {
        List<Passageiro> listaDePassageiros = new ArrayList<>();

        try {
            File arquivoDeLeituraPassageiro = new File(nomeDoArquivoPassageiro);
            Scanner leitorPassageiro = new Scanner(arquivoDeLeituraPassageiro);

            headerPassageiro = leitorPassageiro.nextLine();

            while (leitorPassageiro.hasNextLine()) {
                String linhaPassageiro = leitorPassageiro.nextLine();
                String[] dadosPassageiros = linhaPassageiro.split(";");

                String nome = dadosPassageiros[0];
                String rg = dadosPassageiros[1];
                int idBagagem = Integer.parseInt(dadosPassageiros[2]);
                int idPassagem = Integer.parseInt(dadosPassageiros[3]);
                String assento = dadosPassageiros[4];

                Passagem passagem = new Passagem(idPassagem, assento);
                Passageiro passageiro = new Passageiro(nome, rg, passagem, idBagagem);
                listaDePassageiros.add(passageiro);

                leitorPassageiro.close();
                /* verificar se é viável colocar voo */

            }
        } catch (FileNotFoundException e) {
                Prompt.imprimir("Arquivo não encontrado!");
            } 

            return listaDePassageiros;
        }

        public boolean gravar(List<Passageiro> passageiros) {
            try {
                FileWriter arquivoGravarPassageiro = new FileWriter(nomeDoArquivoPassageiro);
                PrintWriter gravadorPassageiro = new PrintWriter(arquivoGravarPassageiro);

                gravadorPassageiro.println(headerPassageiro);

                for (Passageiro passageiro : passageiros) {
                    gravadorPassageiro.println(passageiro.toString());
                    /* toString ou toCSV? */
                }
                gravadorPassageiro.close();
                return true;
            } catch (IOException e) {
                Prompt.imprimir("Não foi possível gravar o arquivo!");
            }
            return false;
        }
    }
