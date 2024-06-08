package br.edu.up.modelos;

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

    public Voo(Aeronave aeronave2, String idVoo, String origem2, String destino2, Comandante comandante2, Comissario comissario2, Passageiro[] passageiros2, Data dataVoo2, int qtdAssentosDisponiveis2) {
    }
    public Voo(Aeronave aeronave, String idVoo, String origem, String destino) {
        this.aeronave = aeronave;
        this.idVoo = idVoo;
        this.origem = origem;
        this.destino = destino;
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
        return "Voo [origem=" + origem + ", destino=" + destino + ", dataVoo=" + dataVoo + ", qtdAssentosDisponiveis="
                + qtdAssentosDisponiveis + "]";
    }
    

}
