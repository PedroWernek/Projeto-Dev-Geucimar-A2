package br.edu.up.modelos;

public class Passageiro extends Pessoa{
    private Passagem passagem;
    private int idBagagem;
    
    
    

    public Passageiro(String nome, String rg, Passagem passagem, int idBagagem) {
        super(nome, rg);
        this.passagem = passagem;
        this.idBagagem = idBagagem;
    }

    public int getIdBagagem() {
        return idBagagem;
    }
    
    public void setIdBagagem(int idBagagem) {
        this.idBagagem = idBagagem;
    }
    
    public Passagem getPassagem() {
        return passagem;
    }
    
    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    } 

    

    
}
