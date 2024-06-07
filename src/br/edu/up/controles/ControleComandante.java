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
    private List<Pessoa> comandantes;

    public ControleComandante() {
        this.comandantes = new ArrayList<>();
        this.gravador = new GerenciadorDeArquivosComandante();
    }

    public void adicionarComandante(String nome, String rg, int idAeronautica, int idMatricula, int totalHorasVoo) {
        Pessoa comandante = new Comandante(nome, rg, idAeronautica, idMatricula, totalHorasVoo);
        comandantes.add(comandante);
    }

    /* todo: add comandante e deletar */

}
