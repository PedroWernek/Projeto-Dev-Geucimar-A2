package br.edu.up.modelos;

public abstract class Pessoa {
    protected String nome;
    protected String rg;
    
    
    public Pessoa(){
        
    }
    public Pessoa(String nome, String rg) {
        this.nome = nome;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public abstract String toCSV();
}
