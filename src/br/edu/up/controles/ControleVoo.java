package br.edu.up.controles;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.daos.GerenciadorDeArquivosVoo;
import br.edu.up.modelos.*;

public class ControleVoo {
    /* add e deletar voo: TODO */
    private GerenciadorDeArquivosVoo gravador;
    private List<Voo> voos = new ArrayList<>();;

    public ControleVoo(List<Aeronave> aeronaves, List<Pessoa> comandantes, List<Pessoa> comissarios){
        gravador = new GerenciadorDeArquivosVoo();
        voos = gravador.getVoos(aeronaves, comandantes, comissarios);
    }
    
    public void adicionarVoo(Aeronave aeronave, String idVoo, String origem, String destino, Comandante comandante, Comissario comissario, Passageiro[] passageiros, String dataVoo, int qtdAssentosDisponiveis){
        Voo voo = new Voo(aeronave, idVoo, origem, destino, comandante, comissario, dataVoo, qtdAssentosDisponiveis);
        voos.add(voo);
    }

    public boolean deletarVoo(String idVooRemover){
        int i = 0;
        for (Voo voo : voos) {
            if(voo.getIdVoo().equals(idVooRemover)){
                voos.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean gravador(){
        return gravador.gravar(voos);
    }

}