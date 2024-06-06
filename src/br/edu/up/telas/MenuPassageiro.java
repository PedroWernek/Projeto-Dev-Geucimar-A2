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
                    /* adicionar selecionar voo, listar (+ selecionar) quais os assentos disponíveis */
                    nome = Prompt.lerLinha("Informe seu nome: ");
                    rg = Prompt.lerLinha("Informe seu RG: ");

                    int idPassagem = Prompt.lerInteiro("Id passagem:");
                    /* ?? não sei o que fazer com isso */
                    int idBagagem = Prompt.lerInteiro("Id bagagem:");
                    /* ?? */

                    String numAssento = Prompt.lerLinha("Numero assento:");
                    /* listar e selecionar assentos */
                    String classeAssento = Prompt.lerLinha("Classe assento:");
                    /* e precisa disso? */

                    int dia = Prompt.lerInteiro("Dia:");
                    int mes = Prompt.lerInteiro("Mes:");
                    int hora = Prompt.lerInteiro("Hora:");
                    int minuto = Prompt.lerInteiro("Minuto:");
                    /* retirar porque a info já consta no voo */
                    
                    Data data = new Data();
                    data.setDia(dia);
                    data.setMes(mes);
                    data.setHora(hora);
                    data.setMinuto(minuto);

                    Passagem passagem = new Passagem();
                    passagem.setIdPassagem(idPassagem);
                    passagem.setNumAssento(numAssento);
                    passagem.setClasseAssento(classeAssento);
                    passagem.setData(data);

                    Passageiro passageiroo = new Passageiro(nome, rg, passagem, idBagagem);
        
                    //controleAeronave.adicionarPassageiro(passageiroo, pessoas);

                    pessoas ++;

                    break;
                case 2:
                    /* todo */
                case 3:
                    break;
                case 0: Prompt.imprimir("Saindo"); break;
                default: Prompt.imprimir("Dígito inválido!"); break;
            }
        } while(opcao != 0);
    }
}
