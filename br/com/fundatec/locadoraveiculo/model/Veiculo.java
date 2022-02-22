package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;

public  class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private float quilometragem;
    private double valorKmRodado;
    private double valorDiaria;
    private TipoVeiculo tipoVeiculo;

    public Veiculo(String placa, String marca, String modelo, TipoVeiculo tipoVeiculo, float quilometragem, double valorKmRodado,
    		double valorDiaria) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.quilometragem = quilometragem;
        this.valorKmRodado = valorKmRodado;
        this.valorDiaria = valorDiaria;
        this.tipoVeiculo = tipoVeiculo;
    }
    
    public void setQuilometragem(Float novoKm) {
    	quilometragem = novoKm;
    }

    public String getPlaca() {return placa;}

    public String getMarca() {return marca;}

    public String getModelo() {return modelo;}

    public float getQuilometragem() {return quilometragem;}

    public double getValorKmRodado() {return valorKmRodado;}

    public double getValorDiaria() {return valorDiaria;}

    public TipoVeiculo getTipoCarro() {return tipoVeiculo;}
}
