package br.edu.up.modelos;

public abstract class Tripulante extends Pessoa{
    protected double idAeronautica;
    protected double idMatricula;
    
    
    public Tripulante(){

    }
    
    public Tripulante(String nome, String rg, double idAeronautica, double idMatricula) {
        super(nome, rg);
        this.idAeronautica = idAeronautica;
        this.idMatricula = idMatricula;
    }
    
    public double getIdAeronautica() {
        return idAeronautica;
    }
    public void setIdAeronautica(double idAeronautica) {
        this.idAeronautica = idAeronautica;
    }
    public double getIdMatricula() {
        return idMatricula;
    }
    public void setIdMatricula(double idMatricula) {
        this.idMatricula = idMatricula;
    }

}
