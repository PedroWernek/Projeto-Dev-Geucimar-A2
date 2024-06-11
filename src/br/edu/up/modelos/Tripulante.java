package br.edu.up.modelos;

public abstract class Tripulante extends Pessoa{
    protected int idAeronautica;
    protected int idMatricula;
    
    
    public Tripulante(){

    }
    
    public Tripulante(String nome, String rg, int idAeronautica, int idMatricula) {
        super(nome, rg);
        this.idAeronautica = idAeronautica;
        this.idMatricula = idMatricula;
    }
    
    public int getIdAeronautica() {
        return idAeronautica;
    }
    public void setIdAeronautica(int idAeronautica) {
        this.idAeronautica = idAeronautica;
    }
    public int getIdMatricula() {
        return idMatricula;
    }
    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

}
