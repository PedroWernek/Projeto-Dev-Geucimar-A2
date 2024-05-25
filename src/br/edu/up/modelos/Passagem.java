package br.edu.up.modelos;

public class Passagem {
    private int idPassagem;
    private String numAssento;
    private String classeAssento;
    private Data data;
   
   

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
    public String getClasseAssento() {
        return classeAssento;
    }
    public void setClasseAssento(String classeAssento) {
        this.classeAssento = classeAssento;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data dataPassagem) {
        this.data = dataPassagem;
    }

    
    
}
