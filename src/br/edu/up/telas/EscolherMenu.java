package br.edu.up.telas;

import br.edu.up.util.Prompt;

public class EscolherMenu {
    public static void escolha(){
        Prompt.imprimir("Escolha a operação desejada:");
        Prompt.separador();
        Prompt.imprimir("1- Menu Gerente");
        Prompt.imprimir("2- Menu Passageiro");

        int escolha = Prompt.lerInteiro();

        switch (escolha) {
            case 1:
                MenuGerente.executar();    
                break;
            case 2:
                MenuPassageiro.executar();
                break;
            default:
                break;
        }
    }
    
}
