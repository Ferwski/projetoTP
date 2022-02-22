package br.com.fundatec.locadoraveiculo.bancodedados;

import java.util.LinkedList;
import java.util.List;

import br.com.fundatec.locadoraveiculo.model.Cliente;

public class DadosClientes {

    private static DadosClientes instancia;
    private List<Cliente> clientes;

    private DadosClientes() {
        this.clientes = new LinkedList<>();
    }
    public static DadosClientes criar(){
        if(instancia == null){
            instancia = new DadosClientes();
        }
        return instancia;
    }

    public void adicionar(Cliente cliente){
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {return clientes;}
}
