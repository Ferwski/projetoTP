package br.com.fundatec.locadoraveiculo.bancodedados;

import java.util.LinkedList;
import java.util.List;

import br.com.fundatec.locadoraveiculo.model.Locacao;

public class DadosLocacoes {
	

	    private static DadosLocacoes instancia;
	    private List<Locacao> locacoes;

	    private DadosLocacoes() {
	        this.locacoes = new LinkedList<>();
	    }
	    public static DadosLocacoes criar(){
	        if(instancia == null){
	            instancia = new DadosLocacoes();
	        }
	        return instancia;
	    }

	    public void adicionar(Locacao locacao){
	        this.locacoes.add(locacao);
	    }

	    public List<Locacao> getLocacoes() {return locacoes;}
}



