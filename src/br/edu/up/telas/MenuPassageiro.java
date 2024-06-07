package br.edu.up.telas;

import br.edu.up.util.Prompt;
import br.edu.up.controles.*;
import br.edu.up.modelos.*;

public class MenuPassageiro {

    /*
     * precisa manipular passagens: comprar, deletar, consultar (baseado em
     * diferenciador, possivelmente cpf)
     */
    ControlePassageiro controlePassageiro = new ControlePassageiro();

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
                    MenuGerente.listarVoos();
                    int a = Prompt.lerInteiro("Digite o índice do voo desejado: ");

                    nome = Prompt.lerLinha("Informe seu nome: ");
                    rg = Prompt.lerLinha("Informe seu RG: ");

                    MenuGerente.voo.get(a).getAeronave().incrementarIdPassagem();
                    int idPassagem = MenuGerente.voo.get(a).getAeronave().getIdPassagem();

                    MenuGerente.voo.get(a).getAeronave().incrementarIdBagagem();
                    int idBagagem = MenuGerente.voo.get(a).getAeronave().getIdBagagem();

                    MenuGerente.listarAssentosDisponiveis(a);
                    String numAssento = Prompt.lerLinha("Digite o número do assento: ");

                    Passagem passagem = new Passagem();
                    passagem.setIdPassagem(idPassagem);
                    passagem.setNumAssento(numAssento);
                    passagem.setVoo(MenuGerente.voo.get(a));

                    Passageiro passageiro = new Passageiro(nome, rg, passagem, idBagagem);
                    MenuGerente.voo.get(a).reduzirQtdAssentosDisponiveis();
                    /*
                     * refletir se é necessário ter a qtd de assentos disponíveis, se isso
                     * já é definido em espaços vazios no vetor passageiros dentro do voo
                     */

                    // controleAeronave.adicionarPassageiro(passageiro, pessoas);

                    pessoas++;
                    /* o que é isso de pessoas? */
                    break;
                case 2:
                    MenuGerente.listarVoos();
                    a = Prompt.lerInteiro("Digite o índice do seu voo: ");

                    rg = Prompt.lerLinha("Informe seu RG: ");
                    /* TODO: implementar a retirada do passageiro do voo, no controle voo */

                    break;
                case 3:
                    /* todo + refletir se precisa disso! */
                    break;
                case 0:
                    Prompt.imprimir("Saindo...");
                    break;
                default:
                    Prompt.imprimir("Dígito inválido!");
                    break;
            }
        } while (opcao != 0);
    }
}
