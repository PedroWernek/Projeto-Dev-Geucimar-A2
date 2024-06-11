package br.edu.up.controles;

import java.util.List;
import java.util.Iterator;

import br.edu.up.daos.GerenciadorDeArquivosAeronaves;
import br.edu.up.modelos.*;

public class ControleAeronave {

    private GerenciadorDeArquivosAeronaves gravadorArquivos = new GerenciadorDeArquivosAeronaves();
    private List<Aeronave> aeronaves;

    public ControleAeronave() {
        this.aeronaves = gravadorArquivos.getAeronaves();

    }

    public void adicionarAeronave(Aeronave aeronave) {
        aeronaves.add(aeronave);
    }

    public boolean gravar() {
        return gravadorArquivos.gravar(aeronaves);
    }

    public List<Aeronave> getAeronaves() {
        return aeronaves;
    }

    public boolean AtualizarCsv() {
        return gravadorArquivos.gravar(aeronaves);
    }

    public String selecionar(int codigoSelecionar){
        int i = 0;
        try{
            for (Aeronave aeronave : aeronaves) {
                if(aeronave.getIdCodigo() == codigoSelecionar){
                 
                    return aeronave.getIdCodigo() + "," + aeronave.getQtdAssentos() + "," + aeronave.getTipo();
                }
            i++;
            }
        }catch(Exception e){
            ;
        }
        return "Erro";
        
    }


    public boolean deletar(int codigoDeletar) {
        try {
            Iterator<Aeronave> iterator = aeronaves.iterator();
            while (iterator.hasNext()) {
                Aeronave aeronave = iterator.next();
                if (aeronave.getIdCodigo() == codigoDeletar) {
                    iterator.remove();
                    
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar a aeronave");
        }
        return false;
    }

    public List<Aeronave> getaAeronaves(){
        return aeronaves;
    }
}
