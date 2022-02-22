package br.com.fundatec.locadoraveiculo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.fundatec.locadoraveiculo.enums.SituacaoLocacao;

public class Locacao {
	private Cliente cliente;
	private Veiculo veiculo;
	private LocalDate dataLocacao;
	private LocalDate dataEntrega;
	private BigDecimal valor;
	private SituacaoLocacao situacao;

	public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao) {
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataLocacao = dataLocacao;
		this.dataEntrega = null;
		this.valor = null;
		this.situacao = SituacaoLocacao.ATIVA;
	}

	private void setDataLocacao(LocalDate dataLocacao) {
		LocalDate dataAtual = LocalDate.now();
	}
	
	public void encerrar(Float kmVeiculo) {
		if (situacao != SituacaoLocacao.ATIVA) {
			return;
		}
		dataEntrega = LocalDate.now();
		long diarias = ChronoUnit.DAYS.between(dataLocacao, dataEntrega) + 1;
		Float kmAnterior = veiculo.getQuilometragem();
		Double valorDiaria = veiculo.getValorDiaria();
		Double valorKmRodado = veiculo.getValorKmRodado();
		
		valor = BigDecimal.valueOf((diarias * valorDiaria) + ((kmVeiculo - kmAnterior) * valorKmRodado));
		
		veiculo.setQuilometragem(kmVeiculo);
		situacao = SituacaoLocacao.ENCERRADA;
	}
	
	public boolean locAtiva() {
		return SituacaoLocacao.ATIVA == situacao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public LocalDate getDataLocacao() {
		return dataLocacao;
	}
	
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	@Override
	public String toString() {
		return "Locacao [cliente=" + cliente + ", veiculo=" + veiculo + ", dataLocacao=" + dataLocacao
				+ ", dataEntrega=" + dataEntrega + ", valor=" + valor + ", situacao=" + situacao + "]";
	}
	
	

}
