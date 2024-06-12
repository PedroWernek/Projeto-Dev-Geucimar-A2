package br.edu.up.modelos;

public class Comissario extends Tripulante{
    private String idioma;

    
    public Comissario(){
        
    }
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

    @Override
    public String toString() {
        return "Comissario [nome=" + nome + ", idioma=" + idioma + ", idAeronautica=" + idAeronautica + ", rg=" + rg
                + ", idMatricula=" + idMatricula + "]";
    }

    @Override
    public String toCSV() {
        return getNome() + ";" + getRg() + ";" + getIdAeronautica() + ";" + getIdMatricula() + ";" + getIdioma();
    }

    

    

    
    
    //TODO: implementar metodo toCSV para sumir esse erro - PEDRO :);; feito senhor.
}
