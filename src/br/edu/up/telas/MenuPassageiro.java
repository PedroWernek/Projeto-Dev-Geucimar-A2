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

    public static String listarAssentosDisponiveis(int a) {
        if (controleVoo.getVoos().get(a).getPassageiros() == null) {
            return "O voo está vazio.";
        } else {
            StringBuilder sb = new StringBuilder();
            int index = 0;

            for (index = 0; index < controleVoo.getVoos().get(a).getAeronave().getQtdAssentos(); index++) {
                if (controleVoo.getVoos().get(a).getPassageiros()[index] == null) {
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
                    System.out.println(controleVoo.listarVoos());
                    int a = Prompt.lerInteiro("Digite o índice do voo desejado: ");

                    nome = Prompt.lerLinha("Informe seu nome: ");
                    rg = Prompt.lerLinha("Informe seu RG: ");

                    controleVoo.getVoos().get(a).getAeronave().incrementarIdPassagem();
                    int idPassagem = controleVoo.getVoos().get(a).getAeronave().getIdPassagem();

                    controleVoo.getVoos().get(a).getAeronave().incrementarIdBagagem();
                    int idBagagem = controleVoo.getVoos().get(a).getAeronave().getIdBagagem();

                    listarAssentosDisponiveis(a);
                    String numAssento = Prompt.lerLinha("Digite o número do assento: ");

                    Passagem passagem = new Passagem();
                    passagem.setIdPassagem(idPassagem);
                    passagem.setNumAssento(numAssento);
                    passagem.setVoo(controleVoo.getVoos().get(a));

                    Passageiro passageiro = new Passageiro(nome, rg, passagem, idBagagem);
                    controleVoo.getVoos().get(a).reduzirQtdAssentosDisponiveis();

                    if (controlePassageiro.gravador()) {
                        Prompt.imprimir("Passagem gravada com sucesso! :)");
                    }

                    break;
                case 2:
                    controleVoo.listarVoos();
                    a = Prompt.lerInteiro("Digite o índice do seu voo: ");

                    rg = Prompt.lerLinha("Informe seu RG: ");

                    for (int i = 0; i < controlePassageiro.getPassageiros().size(); i++) {
                        if (rg.equals(controlePassageiro.getPassageiros().get(i).getRg())) {
                            if(controleVoo.getVoos().get(a) == controlePassageiro.getPassageiros().get(i).getPassagem().getVoo()) {
                                controlePassageiro.getPassageiros().remove(i);
                                if (controlePassageiro.gravador()) {
                                    Prompt.imprimir("Passagem deletada com sucesso! :)");
                                }
                                break;
                            }
                        }
                    }

                    break;
                case 3:
                    rg = Prompt.lerLinha("Informe seu RG: ");

                    for (int i = 0; i < controlePassageiro.getPassageiros().size(); i++) {
                        if (rg.equals(controlePassageiro.getPassageiros().get(i).getRg())) {
                            Voo voo = controlePassageiro.getPassageiros().get(i).getPassagem().getVoo();
                            Prompt.imprimir("Data: " + voo.getDataVoo() + "\nOrigem: " + voo.getOrigem() + "\nDestino: " + voo.getDestino() + "\nAssento: " + controlePassageiro.getPassageiros().get(i).getPassagem() + "\n");
                        }
                    }
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
