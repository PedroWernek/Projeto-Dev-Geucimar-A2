package br.edu.up.controles;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.daos.GerenciadorDeArquivosVoo;
import br.edu.up.modelos.*;

public class ControleVoo {
    /* add e deletar voo: TODO */
    private GerenciadorDeArquivosVoo gravador;
    private List<Voo> voos;

    public ControleVoo(){
        gravador = new GerenciadorDeArquivosVoo();
        voos = new ArrayList<>();
    }

    public void adicionarVoo(Aeronave aeronave, String idVoo, String origem, String destino, Comandante comandante, Comissario comissario, Passageiro[] passageiros, String dataVoo, int qtdAssentosDisponiveis){
        Voo voo = new Voo(aeronave, idVoo, origem, destino, comandante, comissario, dataVoo, qtdAssentosDisponiveis);
        voos.add(voo);
    }

    public void deletarVoo(String idVoo){
        for (int i = 0; i < voos.size(); i++){
            if(voos.get(i).getIdVoo().equals(idVoo)){
                voos.remove(i);
                return;
            }
        }
    }

    public void getVoos(ControleAeronave cA, ControleComandante cComandante, ControleComissario cComissario){
        gravador.getVoos(cA, cComandante, cComissario);
    }

    public void gravador(){
        gravador.gravar(voos);
    }

}
