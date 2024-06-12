package br.edu.up.controles;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.modelos.Comissario;
import br.edu.up.modelos.Pessoa;
import br.edu.up.daos.GerenciadorDeArquivosComissario;

public class ControleComissario {
    /* todo add comissario e deletar */
    //dei uma copiada no teu pedro pq n tenho muita idéia de como gravar no CSV );  

    private GerenciadorDeArquivosComissario gravador;

    private List<Pessoa> comissarios;

    public ControleComissario() {
        this.comissarios = new ArrayList<>(); 

        this.gravador = new GerenciadorDeArquivosComissario();
        this.comissarios = gravador.getComissario();
    }

    public void cadastrarComissario(String nome, String rg,  int idAeronautica, int idMatricula, String idioma ){
        Comissario comissario = new Comissario(nome, rg, idAeronautica, idMatricula, idioma);
        comissarios.add(comissario);
    }


    public boolean gravar(){
        return gravador.gravar(comissarios);
    }

    public String listar() {
        StringBuilder listaComissarios = new StringBuilder();
        int i = 1;
        for(Pessoa comissario : comissarios){
            listaComissarios.append(i + " - ").append(comissario.toString()).append("\n");
            i++;
        }
        return listaComissarios.toString();

    }

    public boolean remover(String rg){
        int i = 0;
        try{
            for (Pessoa comissario : comissarios) {
                if(comissario.getRg().equals(rg)){
                    comissarios.remove(i);
                    return true;
                }
            i++;
            }
        }catch(Exception e){
        }
        
        return false;
    }

    public List<Pessoa> getComissario(){
        return comissarios;
    }

    public List<Pessoa> getComissarios(){
        return comissarios;
    }
}
