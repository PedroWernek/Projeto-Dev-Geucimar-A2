package br.edu.up.controles;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.modelos.Comandante;
import br.edu.up.modelos.Pessoa;

public class ControleComandante {
    // lista de comandantes
    public List<Pessoa> comandantes;

    public ControleComandante() {
        this.comandantes = new ArrayList<>();
    }

    public void adicionarComandante(String nome, String rg, int idAeronautica, int idMatricula, int totalHorasVoo) {
        Pessoa comandante = new Comandante(nome, rg, idAeronautica, idMatricula, totalHorasVoo);
        comandantes.add(comandante);
    }

    /* todo: add comandante e deletar */

}
