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
import br.edu.up.util.Prompt;
import br.edu.up.controles.ControleAeronave;
import br.edu.up.controles.ControleComandante;
import br.edu.up.controles.ControleComissario;
import br.edu.up.modelos.Aeronave;
import br.edu.up.modelos.Comandante;
import br.edu.up.modelos.Comissario;
import br.edu.up.modelos.Pessoa;
import br.edu.up.modelos.Voo;

public class GerenciadorDeArquivosVoo {

    public String headerVoo = "";
    private String nomeDoArquivoVoo;

    public GerenciadorDeArquivosVoo() {
        Path caminhoArquivoVoo = Paths.get("src", "br", "edu", "up", "docs", "voos.csv");
        nomeDoArquivoVoo = caminhoArquivoVoo.toAbsolutePath().toString();
    }

    public List<Voo> getVoos(ControleAeronave cAeronaves, ControleComandante cComandante, ControleComissario cComissario) {
        List<Voo> listaVoos = new ArrayList<>();

        try {
            File arquivoLeituraVoo = new File(nomeDoArquivoVoo);
            Scanner leitorVoo = new Scanner(arquivoLeituraVoo);

            headerVoo = leitorVoo.nextLine();

            while (leitorVoo.hasNextLine()) {
                String linha = leitorVoo.nextLine();
                String[] dadosVoo = linha.split(";");

                int idAeronave = Integer.parseInt(dadosVoo[0]);
                String idVoo = dadosVoo[1];
                String origem = dadosVoo[2];
                String destino = dadosVoo[3];
                String rgComandante = dadosVoo[4];
                String rgComissario = dadosVoo[5];
                String dataVoo = dadosVoo[6];
                int qtdAssentosDisponiveis = Integer.parseInt(dadosVoo[7]);

                Aeronave aeronave = new Aeronave();
                Pessoa comandante = new Comandante();
                Pessoa comissario = new Comissario();

                //achando aeronave dentro da lista aeronaves
                for (Aeronave aeronaveT : cAeronaves.getAeronaves()) {
                    if(idAeronave == aeronaveT.getIdCodigo()){
                        aeronave = aeronaveT;
                        break;
                    }
                }
                //achando comandante dentro da lista comandantes
                for (Pessoa comandanteT : cComandante.getComandantes()){
                    if(rgComandante == comandanteT.getRg()){
                        comandante = comandanteT;
                        break;
                    }
                }
                //achando comissario dentro da lista comissarios
                for(Pessoa comissarioT : cComissario.getComissarios()){
                    if(rgComissario == comissarioT.getRg()){
                        comissario = comissarioT;
                        break;
                    }
                }

                Voo Voos = new Voo(aeronave, idVoo, origem, destino, comandante, comissario, dataVoo, qtdAssentosDisponiveis);

                listaVoos.add(Voos);

                leitorVoo.close();
            }
        } catch (FileNotFoundException e) {
            Prompt.imprimir("Arquivo não encontrado!");
        }
        return listaVoos;
    }

    public boolean gravar(List<Voo> voos) {
        try {
            FileWriter arquivoGravarVoo = new FileWriter(nomeDoArquivoVoo);
            PrintWriter gravadorVoo = new PrintWriter(arquivoGravarVoo);

            gravadorVoo.println(headerVoo);

            for (Voo voo : voos) {
                gravadorVoo.println(voo.toCSV());
            }
            gravadorVoo.close();
            return true;

        } catch (IOException e) {
            Prompt.imprimir("Não foi possível gravar o arquivo!");
        }
        return false;
    }

}
