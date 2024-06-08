package br.edu.up.controles;

import java.util.ArrayList;

import br.edu.up.modelos.*;

public class ControlePassageiro {
    /* todo add passagem deletar e consultar (ultimo melhor deixar p menu pq e string) */
    ArrayList<Passageiro> passageiros = new ArrayList<>();

    public void adicionarPassageiro(String nome, String rg, Passagem passagem, int idBagagem) {
        Passageiro passageiro = new Passageiro(nome, rg, passagem, idBagagem);
        passageiros.add(passageiro);
    }

    public void deletarPassageiro(String rg) {
        for (int i = 0; i < passageiros.size(); i++) {
            if (passageiros.get(i).getRg().equals(rg)) {
                passageiros.remove(i);
                return;
            }
        }
    }

}
