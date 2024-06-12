package br.edu.up.controles;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.daos.GerenciadorDeArquivosVoo;
import br.edu.up.modelos.*;
import br.edu.up.telas.MenuFuncionario;

public class ControleVoo {
    /* add e deletar voo: TODO */
    private GerenciadorDeArquivosVoo gravadorVoos;
    private List<Voo> voos = new ArrayList<>();

    public ControleVoo(ControleAeronave controleAeronave, MenuFuncionario menuFuncionario){
        gravadorVoos = new GerenciadorDeArquivosVoo();
        voos = gravadorVoos.getVoos(controleAeronave, menuFuncionario.getControleComandante(), menuFuncionario.getControleComissario());
    }
    
    public void adicionarVoo(Aeronave aeronave, String idVoo, String origem, String destino, Comandante comandante, Comissario comissario, Passageiro[] passageiros, String dataVoo, int qtdAssentosDisponiveis){
        Voo voo = new Voo(aeronave, idVoo, origem, destino, comandante, comissario, dataVoo, qtdAssentosDisponiveis);
        voos.add(voo);
        gravador();
    }

    public void deletarVoo(String idVoo){
        for (int i = 0; i < voos.size(); i++){
            if(voos.get(i).getIdVoo().equals(idVoo)){
                voos.remove(i);
                gravador();
                return;
            }
        }
    }

    public void gravador(){
        gravadorVoos.gravar(voos);
    }

}