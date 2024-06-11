package br.edu.up.modelos;

import java.util.Arrays;

public class Voo {
    private Aeronave aeronave;
    private String idVoo;
    private String origem;
    private String destino;
    private Pessoa comandante;
    private Pessoa comissario;
    private String dataVoo;
    private int qtdAssentosDisponiveis;
    public Pessoa[] passageiros;
    public Voo() {
    
    
    }
    
    public Voo(Aeronave aeronave, String idVoo, String origem, String destino, Pessoa comandante,
    Pessoa comissario, String dataVoo, int qtdAssentosDisponiveis) {
        this.aeronave = aeronave;
        this.idVoo = idVoo;
        this.origem = origem;
        this.destino = destino;
        this.comandante = comandante;
        this.comissario = comissario;
        this.dataVoo = dataVoo;
        this.qtdAssentosDisponiveis = qtdAssentosDisponiveis;
    }
    public Aeronave getAeronave() {
        return aeronave;
    }
    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }
    public String getIdVoo() {
        return idVoo;
    }
    public void setIdVoo(String idVoo) {
        this.idVoo = idVoo;
    }
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public Pessoa getComandante() {
        return comandante;
    }
    public void setComandante(Pessoa comandante) {
        this.comandante = comandante;
    }
    public Pessoa getComissario() {
        return comissario;
    }
    public void setComissario(Pessoa comissario) {
        this.comissario = comissario;
    }
    public Pessoa[] getPassageiros() {
        return passageiros;
    }
    public void setPassageiros(Pessoa[] passageiros) {
        this.passageiros = passageiros;
    }
    public String getDataVoo() {
        return dataVoo;
    }
    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }
    public int getQtdAssentosDisponiveis() {
        return qtdAssentosDisponiveis;
    }
    public void setQtdAssentosDisponiveis(int qtdAssentosDisponiveis) {
        this.qtdAssentosDisponiveis = qtdAssentosDisponiveis;
    }

    public void incrementarQtdAssentosDisponiveis() {
        qtdAssentosDisponiveis++;
    }

    public void reduzirQtdAssentosDisponiveis() {
        qtdAssentosDisponiveis--;
    }

    
    
    @Override
    public String toString() {
        return "Voo [aeronave=" + aeronave + ", idVoo=" + idVoo + ", origem=" + origem + ", destino=" + destino
                + ", comandante=" + comandante + ", comissario=" + comissario + ", passageiros="
                + Arrays.toString(passageiros) + ", dataVoo=" + dataVoo + ", qtdAssentosDisponiveis="
                + qtdAssentosDisponiveis + "]";
    }
 
    public String toCSV() {
        return aeronave.getIdCodigo() + ";" + getIdVoo() + ";" + getOrigem() + ";" + getDestino() + ";" + getComandante().getRg() + ";" + getComissario().getRg() + ";" + getDataVoo() + ";" + getQtdAssentosDisponiveis();
    }

}
