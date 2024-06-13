package br.edu.up.telas;

import br.edu.up.util.Prompt;
import br.edu.up.controles.*;
import br.edu.up.modelos.*;

public class MenuPassageiro {

    static ControlePassageiro controlePassageiro = new ControlePassageiro();
    static ControleAeronave controleAeronave = new ControleAeronave();
    static MenuFuncionario menuFuncionario = new MenuFuncionario();
    static ControleVoo controleVoo = new ControleVoo(controleAeronave.getAeronaves(), menuFuncionario.getControleComandante().getComandantes(), menuFuncionario.getControleComissario().getComissarios());

    public static String listarAssentosDisponiveis(int vooIndex) {
        Voo voo = controleVoo.getVoos().get(vooIndex);
        Pessoa[] passageiros = voo.getPassageiros();

        if (passageiros == null || passageiros.length == 0) {
            return "O voo está vazio.";
        } else {
            StringBuilder sb = new StringBuilder();
            int qtdAssentos = voo.getAeronave().getQtdAssentos();

            for (int i = 0; i < qtdAssentos; i++) {
                if (passageiros[i] == null) {
                    sb.append("Assento ").append(i).append(" Disponível!\n");
                }
            }

            return sb.toString();
        }
    }

    public static void executar() {
        int opcao;

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
                    comprarPassagem();
                    break;
                case 2:
                    deletarPassagem();
                    break;
                case 3:
                    consultarPassagens();
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

    private static void comprarPassagem() {
        Prompt.imprimir(controleVoo.listarVoos());
        int vooIndex = Prompt.lerInteiro("Digite o índice do voo desejado: ");

        String nome = Prompt.lerLinha("Informe seu nome: ");
        String rg = Prompt.lerLinha("Informe seu RG: ");

        Voo voo = controleVoo.getVoos().get(vooIndex);
        Aeronave aeronave = voo.getAeronave();

        aeronave.incrementarIdPassagem();
        int idPassagem = aeronave.getIdPassagem();

        aeronave.incrementarIdBagagem();
        int idBagagem = aeronave.getIdBagagem();

        Prompt.imprimir(listarAssentosDisponiveis(vooIndex));
        String numAssento = Prompt.lerLinha("Digite o número do assento: ");

        Passagem passagem = new Passagem();
        passagem.setIdPassagem(idPassagem);
        passagem.setNumAssento(numAssento);
        passagem.setVoo(voo);

        Passageiro passageiro = new Passageiro(nome, rg, passagem, idBagagem);
        voo.reduzirQtdAssentosDisponiveis();

        if (controlePassageiro.gravador()) {
            Prompt.imprimir("Passagem gravada com sucesso! :)");
        }
    }

    
}
