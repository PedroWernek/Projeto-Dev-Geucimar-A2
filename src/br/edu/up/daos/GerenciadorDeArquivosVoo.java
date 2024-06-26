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
import br.edu.up.modelos.Aeronave;
import br.edu.up.modelos.Comandante;
import br.edu.up.modelos.Comissario;
import br.edu.up.modelos.Pessoa;
import br.edu.up.modelos.Voo;

public class GerenciadorDeArquivosVoo {

    public String header= "";
    private String nomeDoArquivo;

    public GerenciadorDeArquivosVoo() {
        Path caminhoArquivo = Paths.get("src", "br", "edu", "up", "docs", "voos.csv");
        nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString();
    }

    public List<Voo> getVoos(List<Aeronave> aeronaves, List<Pessoa> comandantes, List<Pessoa> comissarios) {
        List<Voo> listaVoos = new ArrayList<>();

        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitorVoo = new Scanner(arquivoLeitura);
            header = leitorVoo.nextLine();

            while (leitorVoo.hasNextLine()) {
                String linha = leitorVoo.nextLine();
                String[] dadosVoo = linha.split(";");

                double idAeronave = Double.parseDouble(dadosVoo[0]);
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
                for (Aeronave aeronaveT : aeronaves) {
                    if(idAeronave == aeronaveT.getIdCodigo()){
                        aeronave = aeronaveT;
                        break;
                    }
                }
                //achando comandante dentro da lista comandantes
                for (Pessoa comandanteT : comandantes){
                    if(rgComandante == comandanteT.getRg()){
                        comandante = comandanteT;
                        break;
                    }
                }
                //achando comissario dentro da lista comissarios
                for(Pessoa comissarioT : comissarios){
                    if(rgComissario == comissarioT.getRg()){
                        comissario = comissarioT;
                        break;
                    }
                }

                Voo Voos = new Voo(aeronave, idVoo, origem, destino, comandante, comissario, dataVoo, qtdAssentosDisponiveis);

                listaVoos.add(Voos);

                
            }

            leitorVoo.close();
        } catch (FileNotFoundException e) {
            Prompt.imprimir("Arquivo não encontrado!");
        }
        return listaVoos;
    }

    public boolean gravar(List<Voo> voosG) {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);

            for (Voo voo : voosG) {
                gravador.println(voo.toCSV());
            }
            gravador.close();
            return true;

        } catch (IOException e) {
            Prompt.imprimir("Não foi possível gravar o arquivo!");
        }
        return false;
    }

}
