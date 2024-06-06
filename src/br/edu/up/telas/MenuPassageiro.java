package br.edu.up.telas;

import br.edu.up.util.Prompt;
import java.util.List;
import br.edu.up.controles.*;
import br.edu.up.modelos.*;

public class MenuPassageiro {

    /* precisa manipular passagens: comprar, deletar, consultar (baseado em diferenciador, possivelmente cpf) */
    static ControleAeronave controleAeronave = new ControleAeronave();

    public static void executar() {
        int opcao;
        int pessoas = 0;

        String nome;
        String rg;     
        do {

            Prompt.separador();
            Prompt.imprimir("Bem-vindo ao menu! :) Digite: ");
            Prompt.imprimir("1: Para comprar uma passagem");
            Prompt.imprimir("2: Para deletar sua passagem");
            Prompt.imprimir("3: Para consultar suas passagens");
            Prompt.imprimir("0: Sair");
            opcao = Prompt.lerInteiro();

            switch (opcao) {
                case 1:
                    /* todo: selecionar voo (OK), listar (+ selecionar) quais os assentos disponíveis */
                    MenuGerente.listarVoos();
                    int a = Prompt.lerInteiro("Digite o índice do voo desejado: ");

                    nome = Prompt.lerLinha("Informe seu nome: ");
                    rg = Prompt.lerLinha("Informe seu RG: ");

                    int idPassagem = Prompt.lerInteiro("Id passagem:");
                    /* vou definir como vinda da aeronave do voo aqle contador la */
                    int idBagagem = Prompt.lerInteiro("Id bagagem:");
                    /* mesma coisa */

                    String numAssento = Prompt.lerLinha("Numero assento:");
                    /* todo: listar e selecionar assentos */
                    String classeAssento = Prompt.lerLinha("Classe assento:");
                    /* e precisa disso? */

                    Passagem passagem = new Passagem();
                    passagem.setIdPassagem(idPassagem);
                    passagem.setNumAssento(numAssento);
                    passagem.setClasseAssento(classeAssento);

                    Passageiro passageiroo = new Passageiro(nome, rg, passagem, idBagagem);
        
                    controleAeronave.adicionarPassageiro(passageiroo, pessoas);

                    pessoas ++;

                    break;
                case 2:
                    /* todo */
                    break;
                case 3:
                    /* todo */
                    break;
                case 0: Prompt.imprimir("Saindo..."); break;
                default: Prompt.imprimir("Dígito inválido!"); break;
            }
        } while(opcao != 0);
    }
}
