package br.edu.up.controles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.up.daos.GerenciadorDeArquivosAeronaves;
import br.edu.up.modelos.*;

public class ControleAeronave {
    /*private Pessoa[] pessoas;*/

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


    /*public Comandante buscarComandante() {
 

        for (Pessoa pessoa : pessoas) {

            if(pessoa instanceof Comandante){
                Comandante c = (Comandante) pessoa;
                return c;
            }
            
        }

        return null;
       
    }

    public List<Comandante> buscarComandantes() {
 
        List<Comandante> comandantes = new ArrayList<>();
        
        for (Pessoa pessoa : pessoas) {

            if(pessoa instanceof Comandante){
                Comandante c = (Comandante) pessoa;
                comandantes.add(c);
            }
            
        }

        return comandantes;
       
    }
    public Comissario buscarComissario() {
 

        for (Pessoa pessoa : pessoas) {

            if(pessoa instanceof Comissario){
                Comissario c = (Comissario) pessoa;
                return c;
            }
            
        }

        return null;
       
    }

    public List<Comissario> buscarComissarios() {
 
        List<Comissario> comissarios = new ArrayList<>();
        
        for (Pessoa pessoa : pessoas) {

            if(pessoa instanceof Comissario){
                Comissario c = (Comissario) pessoa;
                comissarios.add(c);
            }
            
        }

        return comissarios;
       
    }
    public Passageiro buscarPassageiro() {
 

        for (Pessoa pessoa : pessoas) {

            if(pessoa instanceof Passageiro){
                Passageiro c = (Passageiro) pessoa;
                return c;
            }
            
        }

        return null;
       
    }

    public List<Passageiro> buscarPassageiros() {
 
        List<Passageiro> passageiros = new ArrayList<>();
        
        for (Pessoa pessoa : pessoas) {

            if(pessoa instanceof Passageiro){
                Passageiro c = (Passageiro) pessoa;
                passageiros.add(c);
            }
            
        }

        return passageiros;
       
    }

    


    public void adicionarPassageiro(Passageiro passageiro, int contPessoas) {
    
        this.pessoas[contPessoas] = passageiro;

    }

    
    
    public void adicionarComandante( Comandante comandante,  int contPessoas ) {
        this.pessoas[contPessoas] = comandante; 
            
    }

    public void adicionarComissario(Comissario comissario,  int contPessoas) {
        this.pessoas[contPessoas] = comissario;
      
    }*/

  

    

}
