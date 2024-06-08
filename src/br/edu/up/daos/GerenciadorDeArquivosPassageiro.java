package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.*;
import br.edu.up.modelos.Passageiro;
import br.edu.up.modelos.Passagem;
import br.edu.up.util.Prompt;

public class GerenciadorDeArquivosPassageiro {
    
    public String header = "";
    private String nomeDoArquivo;

    /* encontra partes em comum do caminho já que os computadores tem caminhos diferentes */
    public GerenciadorDeArquivosPassageiro() {
        Path caminhoRelativo = Paths.get("src", "br", "edu", "up", "docs", "GerenciadorDeArquivosPassageiro");
        nomeDoArquivo = caminhoRelativo.toAbsolutePath().toString();
    }

    /* lê os arquivos */
    public List<Passageiro> getPassageiro() {
        List<Passageiro> listaDePassageiros = new ArrayList<>();

        try {
            File arquivoDeLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoDeLeitura);

            header = leitor.nextLine();

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

            }
        } catch (FileNotFoundException e) {
                Prompt.imprimir("Arquivo não encontrado!");
            } 

            return listaDePassageiros;
        }
    }
