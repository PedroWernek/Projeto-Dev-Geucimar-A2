package br.edu.up.telas;

import br.edu.up.util.Prompt;
import br.edu.up.controles.*;
import br.edu.up.modelos.*;

public class MenuPassageiro {

    /*
     * precisa manipular passagens: comprar, deletar, consultar (baseado em
     * diferenciador, possivelmente rg)
     */
    static ControlePassageiro controlePassageiro = new ControlePassageiro();
    static ControleAeronave controleAeronave = new ControleAeronave();
    static MenuFuncionario menuFuncionario = new MenuFuncionario();
    static ControleVoo controleVoo = new ControleVoo(controleAeronave.getAeronaves(), menuFuncionario.getControleComandante().getComandantes(), menuFuncionario.getControleComissario().getComissarios());

    public static String listarVoos() {
        if (controleVoo.getListaVoo() == null) {
            return "Não há voos registrados.";
        } else {
            StringBuilder sb = new StringBuilder();
            int index = 0;

            for (Voo vooExemplo : controleVoo.getListaVoo()) {
                sb.append("Voo ").append(index).append(":\n");
                sb.append(vooExemplo.toString()).append("\n");
                index++;
            }

            return sb.toString();
        }
    }

    public static String listarAssentosDisponiveis(int a) {
        if (controleVoo.getListaVoo().get(a).getPassageiros() == null) {
            return "O voo está vazio.";
        } else {
            StringBuilder sb = new StringBuilder();
            int index = 0;

            for (index = 0; index < controleVoo.getListaVoo().get(a).getAeronave().getQtdAssentos(); index++) {
                if (controleVoo.getListaVoo().get(a).getPassageiros()[index] == null) {
                    sb.append("Assento ").append(index).append(" Disponível!\n");
                }
            }

            return sb.toString();
        }
    }

    public static void executar() {
        int opcao;
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
                    listarVoos();
                    int a = Prompt.lerInteiro("Digite o índice do voo desejado: ");

                    nome = Prompt.lerLinha("Informe seu nome: ");
                    rg = Prompt.lerLinha("Informe seu RG: ");

                    controleVoo.getListaVoo().get(a).getAeronave().incrementarIdPassagem();
                    int idPassagem = controleVoo.getListaVoo().get(a).getAeronave().getIdPassagem();

                    controleVoo.getListaVoo().get(a).getAeronave().incrementarIdBagagem();
                    int idBagagem = controleVoo.getListaVoo().get(a).getAeronave().getIdBagagem();

                    MenuGerente.listarAssentosDisponiveis(a);
                    String numAssento = Prompt.lerLinha("Digite o número do assento: ");

                    Passagem passagem = new Passagem();
                    passagem.setIdPassagem(idPassagem);
                    passagem.setNumAssento(numAssento);
                    passagem.setVoo(controleVoo.getListaVoo().get(a));

                    Passageiro passageiro = new Passageiro(nome, rg, passagem, idBagagem);
                    controleVoo.getListaVoo().get(a).reduzirQtdAssentosDisponiveis();

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
