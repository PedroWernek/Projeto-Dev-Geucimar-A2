package br.edu.up.telas;

import br.edu.up.util.Prompt;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.controles.ControleAeronave;
import br.edu.up.modelos.Aeronave;
import br.edu.up.modelos.Comandante;
import br.edu.up.modelos.Comissario;
import br.edu.up.modelos.Passageiro;
import br.edu.up.modelos.Passagem;
import br.edu.up.modelos.Data;



public class Menu {

    static ControleAeronave controleAeronave = new ControleAeronave();

    public static void executar() {
        int opcao;
        int pessoas = 0;

        String nome;
        String rg;

        System.out.printf("------------------------- \n");
        int idCodigo = Prompt.lerInteiro("Codigo da aeronave: "); 
        String tipo = Prompt.lerLinha("Tipo: "); 
        int qtdAssentos = Prompt.lerInteiro("Qtd assentos: "); 
       
        Aeronave aeronave = new Aeronave();

        aeronave.setIdCodigo(idCodigo);
        aeronave.setQtdAssentos(qtdAssentos);
        aeronave.setTipo(tipo);

        controleAeronave.adicionarAeronave(aeronave);

       
        do {
            

            System.out.printf("------------------------- \n");
            System.out.printf("Digite a ação que deseja de 1 a 4: \n");
            System.out.printf("1 = Adicionar passageiro\n");
            System.out.printf("2 = Adicionar tripulacao\n");
            System.out.printf("3 = Relatório comandante\n");
            System.out.printf("4 = Relatório comissário\n");
            System.out.printf("5 = Relatório passageiro\n");
            System.out.printf("6 = Sair \n");

            opcao = Prompt.lerInteiro("");
            System.out.printf("------------------------- \n");
            switch (opcao) {
                case 1:
                   

                    nome = Prompt.lerLinha("Nome:");
                    rg = Prompt.lerLinha("Rg:");
                    int idPassagem = Prompt.lerInteiro("Id passagem:");
                    int idBagagem = Prompt.lerInteiro("Id bagagem:");
                    String numAssento = Prompt.lerLinha("Numero assento:");
                    String classeAssento = Prompt.lerLinha("Classe assento:");
                    int dia = Prompt.lerInteiro("Dia:");
                    int mes = Prompt.lerInteiro("Mes:");
                    int hora = Prompt.lerInteiro("Hora:");
                    int minuto = Prompt.lerInteiro("Minuto:");
                    
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
        
                    controleAeronave.adicionarPassageiro(passageiroo, pessoas);

                    pessoas ++;

                    break;
                case 2:
                    

                    nome = Prompt.lerLinha("Nome:");
                    rg = Prompt.lerLinha("Rg:");
                    int tipoTripulacao = Prompt.lerInteiro("Qual tripulante [1 - Comandante / 2 - Comissário]:");
                    int idAeronautica = Prompt.lerInteiro("Id aeronautica: ");
                    int idMatricula = Prompt.lerInteiro("Id matricula: ");


                    if (tipoTripulacao == 1) {

                        int totalHorasVoo = Prompt.lerInteiro("Total de horas de voo: ");     
                        
                        Comandante comandante = new Comandante(nome, rg, idAeronautica, idMatricula, totalHorasVoo);

                        comandante.setIdAeronautica(idAeronautica);
                        comandante.setIdMatricula(idMatricula);
                        comandante.setNome(nome);
                        comandante.setRg(rg);
                        comandante.setTotalHorasVoo(totalHorasVoo);
                        
                        controleAeronave.adicionarComandante(comandante, pessoas); 

                        pessoas ++;

                        break;
                    } else if (tipoTripulacao == 2) {

                        String idiomas = Prompt.lerLinha("idiomas fluentes: ");

                        Comissario comissario = new Comissario(nome, rg, idAeronautica, idMatricula, idiomas);

                        comissario.setIdAeronautica(idAeronautica);
                        comissario.setIdMatricula(idMatricula);
                        comissario.setNome(nome);
                        comissario.setRg(rg);
                        comissario.setIdioma(idiomas);
                        controleAeronave.adicionarComissario(comissario, pessoas);
                       
                        pessoas ++;

                        break;
                    }
                case 3:


                    List<Comandante> comandantes = controleAeronave.buscarComandantes();
                    int comandanteCont = 1;
                    for (Comandante comandante : comandantes) {
                        System.out.printf("Comandante %d: \n", comandanteCont);
                        System.out.println("Nome: " + comandante.getNome());
                        System.out.println("RG: " +comandante.getRg());
                        System.out.println("Id Aeronautica: " +comandante.getIdAeronautica());
                        System.out.println("Id Matricula: " +comandante.getIdMatricula());
                        System.out.println("Total horas de voo: " +comandante.getTotalHorasVoo());
                        comandanteCont ++;
                    }


                    break;
                case 4:
                    List<Comissario> comissarios = controleAeronave.buscarComissarios();
                    int comissarioCont = 1;
                    for (Comissario comissario : comissarios) {
                        System.out.printf("Comissario %d: \n", comissarioCont);
                        System.out.println("Nome: " +comissario.getNome());
                        System.out.println("RG: " +comissario.getRg());
                        System.out.println("Id Aeronautica: " +comissario.getIdAeronautica());
                        System.out.println("Id Matricula: " +comissario.getIdMatricula());
                        System.out.println("Idiomas: " +comissario.getIdioma());
                        comissarioCont ++;
                    }
                    break;
                case 5:
                    List<Passageiro> passageiros = controleAeronave.buscarPassageiros();
                    int passageiroCont = 1;
                    for (Passageiro passageiro : passageiros) {
                        System.out.printf("Passageiro %d: \n", passageiroCont);
                        System.out.println("Nome: " +passageiro.getNome());
                        System.out.println("RG: " +passageiro.getRg());
                        System.out.println("Id Bagagem: " +passageiro.getIdBagagem());
                        System.out.println("Classe assento: " +passageiro.getPassagem().getClasseAssento());
                        System.out.println("Id passagem: " +passageiro.getPassagem().getIdPassagem());
                        System.out.println("Dia: " +passageiro.getPassagem().getData().getDia());
                        System.out.println("Mes: " +passageiro.getPassagem().getData().getMes());
                        System.out.println("Hora: " +passageiro.getPassagem().getData().getHora());
                        System.out.println("Minuto: " +passageiro.getPassagem().getData().getMinuto());

                        passageiroCont ++;
                        
                    }
                    break;
                default:
                    break;
            }
            if (opcao == 6) {
                break;
            }
        } while(opcao != 6);
    }
}
