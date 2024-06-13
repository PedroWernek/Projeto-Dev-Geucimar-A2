package br.edu.up.controles;

import java.util.ArrayList;

import br.edu.up.daos.GerenciadorDeArquivosPassageiro;
import br.edu.up.modelos.*;

public class ControlePassageiro {
    private GerenciadorDeArquivosPassageiro gravador;
    ArrayList<Passageiro> passageiros = new ArrayList<>();

    public ControlePassageiro() {
        this.gravador = new GerenciadorDeArquivosPassageiro(); 
        this.passageiros = new ArrayList<>();
    }

    public void adicionarPassageiro(Passageiro passageiro) {
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

    public boolean gravador(){
        return gravador.gravar(passageiros);
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(ArrayList<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

}
