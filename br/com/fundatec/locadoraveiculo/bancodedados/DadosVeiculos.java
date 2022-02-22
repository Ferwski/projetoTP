package br.com.fundatec.locadoraveiculo.bancodedados;

import java.util.LinkedList;
import java.util.List;

import br.com.fundatec.locadoraveiculo.model.Veiculo;

public class DadosVeiculos {

    private static DadosVeiculos instancia;
    private List<Veiculo> veiculos;

    private DadosVeiculos() {
        this.veiculos = new LinkedList<>();
    }
    public static DadosVeiculos criar(){
        if(instancia == null){
            instancia = new DadosVeiculos();
        }
        return instancia;
    }

    public void adicionar(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

    public List<Veiculo> getVeiculos() {return veiculos;}
}
