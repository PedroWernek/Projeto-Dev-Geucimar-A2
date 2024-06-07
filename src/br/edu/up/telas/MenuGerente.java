package br.edu.up.telas;

import br.edu.up.util.Prompt;

import java.util.ArrayList;
import br.edu.up.controles.*;
import br.edu.up.modelos.*;

public class MenuGerente {
    /*
     * precisa manipular: aeronaves, voos e funcionários (adicionar, editar,
     * excluir, selecionar)
     */
    static ControleAeronave controleAeronave = new ControleAeronave();
    /* Pedro - criando controle Comandante */
    static ControleComandante controleComandante = new ControleComandante();

    static ArrayList<Voo> voo = new ArrayList<Voo>();

    public static String listarVoos() {
        if (voo == null) {
            return "Não há voos registrados.";
        } else {
            StringBuilder sb = new StringBuilder();
            int index = 0;

            for (Voo vooExemplo : voo) {
                sb.append("Voo ").append(index).append(":\n");
                sb.append(vooExemplo.toString()).append("\n");
                index++;
            }

            return sb.toString();
        }
    }

    public static String listarAssentosDisponiveis(int a) {
        if (voo.get(a).getPassageiros() == null) {
            return "O voo está vazio.";
        } else {
            StringBuilder sb = new StringBuilder();
            int index = 0;

            for (index = 0; index < voo.get(a).getAeronave().getQtdAssentos(); index++) {
                if (voo.get(a).getPassageiros()[index] == null) {
                    sb.append("Assento ").append(index).append(" Disponível!\n");
                }
            }

            return sb.toString();
        }
    }

    public static void executar() {
        int opcao = 0;
        //int pessoas = 0;

        String nome;
        String rg;

        do {
            Prompt.separador();
            Prompt.imprimir("Bem-vindo ao menu! :) Digite: ");
            Prompt.imprimir("1: Adicionar Aeronave");
            Prompt.imprimir("2: Listar Aeronaves");
            Prompt.imprimir("3: Adicionar Voo");
            Prompt.imprimir("4: Adicionar Funcionário");/* Pedro - fazendo o registrar do Comandante */
            Prompt.imprimir("5: Deletar Voo");
            Prompt.imprimir("6: Deletar Funcionário");
            Prompt.imprimir("0: Sair");
            /*
             * 1: ControleAeronave / 2: ControleVoo / 3: Comissario e Comandante (???) / 5:
             * ControleVoo / 6: Comissario e Comandante
             */
            opcao = Prompt.lerInteiro();

            if (opcao == 0) {
                break;
            }

            switch (opcao) {
                case 1:
                    Prompt.imprimir("-------------------------\n");
                    int idCodigo = Prompt.lerInteiro("Codigo da aeronave: ");
                    String tipo = Prompt.lerLinha("Tipo: ");
                    int qtdAssentos = Prompt.lerInteiro("Qtd assentos: ");

                    Aeronave aeronave = new Aeronave();

                    aeronave.setIdCodigo(idCodigo);
                    aeronave.setQtdAssentos(qtdAssentos);
                    aeronave.setTipo(tipo);

                    controleAeronave.adicionarAeronave(aeronave);

                    if (controleAeronave.gravar()) {
                        System.out.println("Gravado com sucesso");
                    }

                    break;
                case 2:

                    /* edu fazer */

                    break;
                case 3:
                    /*
                     * blabla coisa importante
                     * infor p adicionar tripulação abaixo:
                     * TODO: quando o voo e inicializado, definir a qtd de assentos da aeronave como
                     * inguais ao do
                     * voo, pra gente conseguir retirar assentos disponveis depois
                     */

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

                        // controleAeronave.adicionarComandante(comandante, pessoas);

                        //pessoas++;

                        break;
                    } else if (tipoTripulacao == 2) {

                        String idiomas = Prompt.lerLinha("idiomas fluentes: ");

                        Comissario comissario = new Comissario(nome, rg, idAeronautica, idMatricula, idiomas);

                        comissario.setIdAeronautica(idAeronautica);
                        comissario.setIdMatricula(idMatricula);
                        comissario.setNome(nome);
                        comissario.setRg(rg);
                        comissario.setIdioma(idiomas);
                        // controleAeronave.adicionarComissario(comissario, pessoas);

                        //pessoas++;

                        break;
                    }

                case 4:
                case 5:
                case 6:
                case 0:
                default:
                    Prompt.imprimir("Dígito inválido!");
            }
        } while (opcao != 0);

        /*
         * RELATÓRIO COMANDANTE:
         * List<Comandante> comandantes = controleAeronave.buscarComandantes();
         * int comandanteCont = 1;
         * for (Comandante comandante : comandantes) {
         * System.out.printf("Comandante %d: \n", comandanteCont);
         * System.out.println("Nome: " + comandante.getNome());
         * System.out.println("RG: " +comandante.getRg());
         * System.out.println("Id Aeronautica: " +comandante.getIdAeronautica());
         * System.out.println("Id Matricula: " +comandante.getIdMatricula());
         * System.out.println("Total horas de voo: " +comandante.getTotalHorasVoo());
         * comandanteCont ++;
         * }
         * RELATÓRIO COMISSÁRIO:
         * List<Comissario> comissarios = controleAeronave.buscarComissarios();
         * int comissarioCont = 1;
         * for (Comissario comissario : comissarios) {
         * System.out.printf("Comissario %d: \n", comissarioCont);
         * System.out.println("Nome: " +comissario.getNome());
         * System.out.println("RG: " +comissario.getRg());
         * System.out.println("Id Aeronautica: " +comissario.getIdAeronautica());
         * System.out.println("Id Matricula: " +comissario.getIdMatricula());
         * System.out.println("Idiomas: " +comissario.getIdioma());
         * comissarioCont ++;
         * }
         * break;
         * RELATÓRIO PASSAGEIRO:
         * List<Passageiro> passageiros = controleAeronave.buscarPassageiros();
         * int passageiroCont = 1;
         * for (Passageiro passageiro : passageiros) {
         * System.out.printf("Passageiro %d: \n", passageiroCont);
         * System.out.println("Nome: " +passageiro.getNome());
         * System.out.println("RG: " +passageiro.getRg());
         * System.out.println("Id Bagagem: " +passageiro.getIdBagagem());
         * System.out.println("Classe assento: "
         * +passageiro.getPassagem().getClasseAssento());
         * System.out.println("Id passagem: "
         * +passageiro.getPassagem().getIdPassagem());
         * System.out.println("Dia: " +passageiro.getPassagem().getData().getDia());
         * System.out.println("Mes: " +passageiro.getPassagem().getData().getMes());
         * System.out.println("Hora: " +passageiro.getPassagem().getData().getHora());
         * System.out.println("Minuto: "
         * +passageiro.getPassagem().getData().getMinuto());
         * 
         * passageiroCont ++;
         * 
         * }
         */
    }

}
