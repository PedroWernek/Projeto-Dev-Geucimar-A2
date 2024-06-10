package br.edu.up.modelos;

public class Comandante extends Tripulante{
    private int totalHorasVoo;

    

    public Comandante(String nome, String rg, int idAeronautica, int idMatricula, int totalHorasVoo) {
        super(nome, rg, idAeronautica, idMatricula);
        this.totalHorasVoo = totalHorasVoo;
    }

    public int getTotalHorasVoo() {
        return totalHorasVoo;
    }

    public void setTotalHorasVoo(int totalHorasVoo) {
        this.totalHorasVoo = totalHorasVoo;
    }


    
    @Override
    public String toString() {
        return "Comandante [nome=" + nome + ", rg=" + rg + ", idMatricula=" + idMatricula + ", totalHorasVoo=" + totalHorasVoo + ", idAeronautica=" + idAeronautica
                + "]";
    }

    @Override
    public String toCSV() {
        return getNome() + ";" + getRg() + ";" + getIdAeronautica() + ";" + getIdMatricula() + ";" + getTotalHorasVoo();
    }
    
    
}
