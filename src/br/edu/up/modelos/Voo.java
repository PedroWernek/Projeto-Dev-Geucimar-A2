package br.edu.up.modelos;

import java.util.Arrays;

public class Voo {
    private Aeronave aeronave;
    private String idVoo;
    private String origem;
    private String destino;
    private Comandante comandante;
    private Comissario comissario;
    private Passageiro[] passageiros;
    private Data dataVoo;
    private int qtdAssentosDisponiveis;

    public Voo() {
    }


    
    
    public Voo(Aeronave aeronave, String idVoo, String origem, String destino, Comandante comandante,
            Comissario comissario, Passageiro[] passageiros, Data dataVoo, int qtdAssentosDisponiveis) {
        this.aeronave = aeronave;
        this.idVoo = idVoo;
        this.origem = origem;
        this.destino = destino;
        this.comandante = comandante;
        this.comissario = comissario;
        this.passageiros = passageiros;
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
    public Comandante getComandante() {
        return comandante;
    }
    public void setComandante(Comandante comandante) {
        this.comandante = comandante;
    }
    public Comissario getComissario() {
        return comissario;
    }
    public void setComissario(Comissario comissario) {
        this.comissario = comissario;
    }
    public Passageiro[] getPassageiros() {
        return passageiros;
    }
    public void setPassageiros(Passageiro[] passageiros) {
        this.passageiros = passageiros;
    }
    public Data getDataVoo() {
        return dataVoo;
    }
    public void setDataVoo(Data dataVoo) {
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
        return getAeronave() + ";" + getIdVoo() + ";" + getOrigem() + ";" + getDestino() + ";" + getComandante() + ";" + getComissario() + ";" + Arrays.toString(passageiros) + ";" + getDataVoo() + ";" + getQtdAssentosDisponiveis();
    }

}
