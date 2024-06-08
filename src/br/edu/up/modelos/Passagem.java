package br.edu.up.modelos;

public class Passagem {

    private int idPassagem;
    private String numAssento;
    private Voo voo;
   
    public Passagem(int idPassagem, String numAssento) {
        this.idPassagem = idPassagem;
        this.numAssento = numAssento;
    }

    public Passagem() {
    }

    public int getIdPassagem() {
        return idPassagem;
    }
    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }
    public String getNumAssento() {
        return numAssento;
    }
    public void setNumAssento(String numAssento) {
        this.numAssento = numAssento;
    }
    public Voo getVoo() {
        return voo;
    }
    public void setVoo(Voo voo) {
        this.voo = voo;
    }
}
