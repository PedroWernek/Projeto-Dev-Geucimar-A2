package br.edu.up.modelos;

public class Aeronave {

    private int idCodigo;
    private String tipo;
    private int qtdAssentos;
    private Pessoa[] pessoas;
   
     /* ideia: a idpassagem e idbagagem são ints crescentes definidas aqui. ou seja, independente do voo,
     * a int continua crescendo. se o passageiro poder escolher os ids, o que garante que dois n vão escolher os
     * mesmos? a gente acessa isso por meio de voo.getAeronave().incrementarIdPassagem() ou algo asi. fiz coisa
     * parecida no cinco e no sete [cinco tenho ctz sete n lembro se tirei]
     */
    private int idPassagem;
    private int idPassageiro;
    /* o que é idPassageiro */
   
    public int getIdCodigo() {
        return idCodigo;
    }
    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getQtdAssentos() {
        return qtdAssentos;
    }
    public void setQtdAssentos(int qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }
    public Pessoa[] getPessoa() {
        return pessoas;
    }
    public void setPessoa(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }
    public int getIdPassagem() {
        return idPassagem;
    }
    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }
    public int getIdPassageiro() {
        return idPassageiro;
    }
    public void setIdPassageiro(int idPassageiro) {
        this.idPassageiro = idPassageiro;
    }
    public void incrementarIdPassagem() {
        idPassagem++;
    }
}
