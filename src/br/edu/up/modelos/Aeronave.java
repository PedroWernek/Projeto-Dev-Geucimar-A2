package br.edu.up.modelos;

public class Aeronave {

    private int idCodigo;
    private String tipo;
    private int qtdAssentos;

    private Pessoa[] pessoas;
   
   
   
   
    public int getIdCodigo() {
        return idCodigo;
    }
    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getQtdAssentos() {
        return qtdAssentos;
    }
    public void setQtdAssentos(int qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }
    public Pessoa[] getPessoa() {
        return pessoas;
    }
    public void setPessoa(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }




}
