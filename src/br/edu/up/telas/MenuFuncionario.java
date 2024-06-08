package br.edu.up.telas;

import br.edu.up.controles.ControleComandante;
import br.edu.up.controles.ControleComissario;
import br.edu.up.util.Prompt;

public class MenuFuncionario {
  /* Pedro - criando controle Comandante */
  public ControleComandante controleComandante;
  public ControleComissario controleComissario;

  public MenuFuncionario() {
    this.controleComandante = new ControleComandante();
    this.controleComissario = new ControleComissario();
  }

  public void mostrar() {
    Prompt.imprimir("--------MENU ADICIONAR FUNCIONARIO--------");
    Prompt.imprimir("1- Comandante");
    Prompt.imprimir("2- Comissario");
    Prompt.imprimir("------------------------------------------");

    int escolha = Prompt.lerInteiro();

    switch (escolha) {
      case 1:
        adicionarComandante();
        break;
      case 2:
        break;
      default:
        Prompt.imprimir("Escolha invalida");
        mostrar();
        break;
    }

  }

  public void adicionarComandante() {

    String nome = Prompt.lerLinha("Nome:");
    String rg = Prompt.lerLinha("RG:");
    int idAeronautica = Prompt.lerInteiro("Id aeronautica:");
    int idMatricula = Prompt.lerInteiro("Id matricula:");
    int totalHorasVoo = Prompt.lerInteiro("Total de horas de voo:");

    controleComandante.adicionarComandante(nome, rg, idAeronautica, idMatricula, totalHorasVoo);

    if (controleComandante.gravar()) {
      Prompt.imprimir("Comandante adicionado com sucesso!");
    } else {
      Prompt.imprimir("Erro ao adicionar comandante!");
    }

    Prompt.pressionarEnter();
  }
}
