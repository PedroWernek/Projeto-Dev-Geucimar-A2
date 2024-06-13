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

    public String listarVoos() {
        StringBuilder listaVoos = new StringBuilder();
        int i = 1;
        for (Voo voo : voos) {
            listaVoos.append(i).append(" - ");
            listaVoos.append("Aeronave: ").append(voo.getAeronave().getIdCodigo()).append(";").append(voo.getAeronave().getQtdAssentos()).append(" ;").append(voo.getAeronave().getTipo()).append(", ");
            listaVoos.append("ID do Voo: ").append(voo.getIdVoo()).append(", ");
            listaVoos.append("Origem: ").append(voo.getOrigem()).append(", ");
            listaVoos.append("Destino: ").append(voo.getDestino()).append(", ");
            listaVoos.append("Comandante: ").append(voo.getComandante().getRg()).append(", ");
            listaVoos.append("Comissário: ").append(voo.getComissario().getRg()).append(", ");
            listaVoos.append("Data do Voo: ").append(voo.getDataVoo()).append(", ");
            listaVoos.append("Assentos Disponíveis: ").append(voo.getQtdAssentosDisponiveis()).append("\n");
            i++;
        }
        return listaVoos.toString();
    }
    

    public List<Voo> getVoos() {
        return voos;
    }

    public Voo getVoo(int id){
        for (Voo voo : voos) {
            if (Integer.parseInt(voo.getIdVoo()) == id) {
                return voo;
            }
        }
        return null;
    }

    public void setVoos(List<Voo> voos) {
        this.voos = voos;
    }

    public boolean gravador(){
        return gravador.gravar(voos);
    }

}