package br.edu.up.controles;

import java.util.ArrayList;

import br.edu.up.modelos.*;

public class ControleVoo {
    /* add e deletar voo: TODO */

    ArrayList<Voo> voos = new ArrayList<>();

    public void adicionarVoo(Aeronave aeronave, String idVoo, String origem, String destino, Comandante comandante, Comissario comissario, Passageiro[] passageiros, Data dataVoo, int qtdAssentosDisponiveis){
        Voo voo = new Voo(aeronave, idVoo, origem, destino, comandante, comissario, passageiros, dataVoo, qtdAssentosDisponiveis);
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

}
