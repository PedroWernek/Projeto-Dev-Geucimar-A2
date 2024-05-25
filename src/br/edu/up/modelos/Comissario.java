package br.edu.up.modelos;

public class Comissario extends Tripulante{
    private String idioma;

    

    public Comissario(String nome, String rg, int idAeronautica, int idMatricula, String idioma) {
        super(nome, rg, idAeronautica, idMatricula);
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    
}
