package br.edu.up.telas;

import br.edu.up.util.Prompt;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.controles.*;
import br.edu.up.modelos.*;

public class MenuGerente {
    /*
     * precisa manipular: aeronaves, voos e funcionários (adicionar, editar,
     * excluir, selecionar)
     */
    static ControleAeronave controleAeronave = new ControleAeronave();

    // => Pedro - Criando MenuFuncionario
    static MenuFuncionario menuFuncionario = new MenuFuncionario();

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
        // int pessoas = 0;

        String nome;
        String rg;
        Prompt.limparConsole();
        do {

            Prompt.separador();
            Prompt.imprimir("Bem-vindo ao menu! :) Digite: ");
            Prompt.imprimir("1: Adicionar Aeronave");
            Prompt.imprimir("2: Listar Aeronaves");
            Prompt.imprimir("3: Deletar Aeronave");
            Prompt.imprimir("4: Adicionar Voo");
            Prompt.imprimir("5: Deletar Voo");
            Prompt.imprimir("6: Adicionar Funcionário");/* Pedro - fazendo o registrar de Funcionario */
            Prompt.imprimir("7: Listar Funcionários");/* Pedro - fazendo o listar Funcionarios no menuFuncionarios */
            Prompt.imprimir("8: Deletar Funcionário");/* Pedro - fazendo o registrar de Funcionario */
            Prompt.imprimir("0: Sair");

            /*
             * algm colocou mais funcoes e n mudou as coisas aqui embaixo:
             * 1. ADICIONAR AERONAVE: ControleAeronave
             * 2. LISTAR AERONAVES: ControleAeronave
             * 3. ADD VOO: ControleVoo
             * 4. DELETAR VOO: ControleVoo
             * 5. ADD FUNCIONARIO: caue e pedro
             * 6. DELETAR FUNICONARIO: caue e pedro
             */
            opcao = Prompt.lerInteiro();

            if (opcao == 0) {
                break;
            }

            switch (opcao) {
                case 1:
                /* edu adicionar AERONAVES */
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

                    /* edu LISTAR AERONAVES */
                    Prompt.separador();
                    List<Aeronave> listaDeAeronaves = controleAeronave.getAeronaves();
                    for (Aeronave aeronaves : listaDeAeronaves) {
                        System.out.println(aeronaves.getIdCodigo() + " / " + aeronaves.getQtdAssentos() + " / "
                                + aeronaves.getTipo());
                    }

                    break;

                case 3:
                /* edu REMOVER AERONAVES */
                    Prompt.separador();
                    String resposta = Prompt.lerLinha("Deseja mesmo deletar? [S - Sim / n / Nao]");
                    
                    if (resposta.toUpperCase().equals("S")) {
                        int codigoDeletar = Prompt.lerInteiro("Codigo da Aeronave que deseja deletar: ");
                        if (controleAeronave.deletar(codigoDeletar)) {
                            controleAeronave.gravar();
                            System.out.println("Aeronave removida com sucesso!");
                        } else {
                            System.out.println("Aeronave nao encontrada!");
                        }
                    } else if (resposta.toUpperCase().equals("N")) {
                        break;
                    }

                    break;
                
              
                
                case 4:
                // 1. listar as aeronaves;
                List<Aeronave> listaDeAeronavesVoo = controleAeronave.getAeronaves();
                for (Aeronave aeronaves : listaDeAeronavesVoo) {
                    System.out.println(aeronaves.getIdCodigo() + " / " + aeronaves.getQtdAssentos() + " / "
                            + aeronaves.getTipo());
                }
                // 2. escolher uma pelo codigo dela;
                int codigoEscolhido = Prompt.lerInteiro("Digite o codigo da aeronave que deseja escolher:");

                // 3. trazer os dados idcodigo, qtdassentos e tipo da aeronave selecionada;
                System.out.println(controleAeronave.selecionar(codigoEscolhido));

                // 3. declarar aeronave para depois adicionar dados a ela
                Aeronave aeronaveVoo = new Aeronave();

                // 5. adicionar dados
                controleAeronave.selecionar(codigoEscolhido)
                
                // aeronaveVoo.setIdCodigo(idCodigo);
                // aeronaveVoo.setQtdAssentos(qtdAssentos);
                // aeronaveVoo.setTipo(tipo);
                break;
                    

                case 5:
                    break;
                case 6:
                    // TODO: estou fazendo um menu só para criar funcionario
                    /*
                     * Assim aqui CAUÊ você também cria comissario junto comigo
                     */
                    menuFuncionario.adicionarFuncionario();

                    break;
                case 7:
                    menuFuncionario.listarFuncionarios();
                    break;
                case 8:
                    menuFuncionario.removerFuncionario();
                    break;
                case 0:
                    break;
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
