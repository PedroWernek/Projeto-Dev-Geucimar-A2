package br.edu.up.controles;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.daos.GerenciadorDeArquivosComandante;
import br.edu.up.modelos.Comandante;
import br.edu.up.modelos.Pessoa;

public class ControleComandante {
    // gravador de Arquivos
    private GerenciadorDeArquivosComandante gravador;
    // lista de comandantes
    private List<Pessoa> comandantes = new ArrayList<>();

    public ControleComandante() {
        this.gravador = new GerenciadorDeArquivosComandante();
        this.comandantes = gravador.getComandantes();
    }
    /**
     * Aqui estou criando um novo comandante
     * para ser adicionado na lista "comandantes"
     */
    public void adicionar(String nome, String rg, int idAeronautica, int idMatricula, int totalHorasVoo) {
        Pessoa comandante = new Comandante(nome, rg, idAeronautica, idMatricula, totalHorasVoo);
        comandantes.add(comandante);
    }
    /**
     * Aqui estou gravando todos os Comandantes
     * do da lista "comandantes"
     * no arquivo "comandantes.csv"
     * e esperando um sinal TRUE na função
     */
    public boolean gravar(){
        return gravador.gravar(comandantes);
    }

    /**
     * Listando todos os comandantes
     * da lista "comandantes"
     * @return String
     */
    public String listar() {
        StringBuilder listaComandantes = new StringBuilder();
        int i = 1;
        for(Pessoa comandante : comandantes){
            listaComandantes.append(i + " - ").append(comandante.toString()).append("\n");
            i++;
        }
        return listaComandantes.toString();
    }
    /* todo: deletar */

    public boolean remover(String rg){
        int i = 0;
        try{
            for (Pessoa comandante : comandantes) {
                if(comandante.getRg().equals(rg)){
                    comandantes.remove(i);
                    return true;
                }
            i++;
            }
        }catch(Exception e){
        }
        
        return false;
    }

}
