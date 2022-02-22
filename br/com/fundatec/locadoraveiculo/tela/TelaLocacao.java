package br.com.fundatec.locadoraveiculo.tela;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.fundatec.locadoraveiculo.bancodedados.DadosClientes;
import br.com.fundatec.locadoraveiculo.bancodedados.DadosLocacoes;
import br.com.fundatec.locadoraveiculo.bancodedados.DadosVeiculos;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Locacao;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

public class TelaLocacao {
	Scanner console = new Scanner(System.in);
	private DadosLocacoes dadosLocacoes = DadosLocacoes.criar();

	public TelaLocacao() {

	}

	private void desenharMenu() {
		System.out.println(" ______________________________________");
		System.out.println("|           MENU DE LOCAÇÕES           |");
		System.out.println("|______________________________________|");
		System.out.println("|    Digite uma opção abaixo:          |");
		System.out.println("|  [1] - Cadastrar locações            |");
		System.out.println("|  [2] - Encerrar locações             |");
		System.out.println("|  [3] - Listar locações               |");
		System.out.println("|  [0] - Retornar ao menu principal    |");
		System.out.println("+--------------------------------------+");
	}

	public void imprimirMenu() {
		do {
			this.desenharMenu();
			int opcao;
			try {
				opcao = console.nextInt();
			} catch (InputMismatchException excecao) {
				console.nextInt();
				opcao = -1;
			}
			Long documento;
			String placa;
			LocalDate dataLocacao;
			Cliente novoCliente;
			Veiculo novoVeiculo;
			switch (opcao) {
			
			
			case 1:
				System.out.println("Informe o número do documento: ");
				documento = console.nextLong();
				novoCliente = null;
				for (Cliente cliente : DadosClientes.criar().getClientes()) {
					if (documento.equals(cliente.getDocumento())) {
						novoCliente = cliente;
						break;
					}
				}
//				} if (novoCliente == null) {
//					System.out.println("Cliente não encontrado!");					
//				}
				System.out.println("Informe a placa do veículo: ");
				placa = console.next();
				novoVeiculo = null;
				for (Veiculo veiculo : DadosVeiculos.criar().getVeiculos()) {
					if (placa.equals(veiculo.getPlaca())) {
						novoVeiculo = veiculo;
						break;
					}
				}
//				} if (novoVeiculo == null) {
//					System.out.println("Veiculo não encontrado!");					
//				}
				System.out.println("Informe a data da locação: ");
				dataLocacao = LocalDate.parse(console.next());
				this.cadastrarLocacoes(novoCliente, novoVeiculo, dataLocacao);
				break;
				
				
			case 2:
				System.out.println("Informe o número do documento: ");
				documento = console.nextLong();
				novoCliente = null;
				for (Cliente cliente : DadosClientes.criar().getClientes()) {
					if (documento.equals(cliente.getDocumento())) {
						novoCliente = cliente;
						break;
					}
				}
//				} if (novoCliente == null) {
//					System.out.println("Cliente não encontrado!");					
//				}
				System.out.println("Informe a placa do veículo: ");
				placa = console.next();
				novoVeiculo = null;
				for (Veiculo veiculo : DadosVeiculos.criar().getVeiculos()) {
					if (placa.equals(veiculo.getPlaca())) {
						novoVeiculo = veiculo;
						break;
					}
				}
//				} if (novoVeiculo == null) {
//				System.out.println("Veiculo não encontrado!");					
//			}
				System.out.println("Informe a data da locação: ");
				dataLocacao = LocalDate.parse(console.next());
				System.out.println("Informe a quilometragem atual: ");
				Float kmAtual = console.nextFloat();
				this.encerrarLocacoes(novoCliente, novoVeiculo, dataLocacao, kmAtual);
				break;
				
				
			case 3:
				;
				break;
			case 0:
				System.out.println("Retornando ao Menu Principal...");
				return;
			default:
				System.out.println("Opção inválida, digite novamente.");
				break;
			}
		} while (true);
	}

	public void cadastrarLocacoes(Cliente novoCliente, Veiculo novoVeiculo, LocalDate dataLocacao) {
		dadosLocacoes.adicionar(new Locacao(novoCliente, novoVeiculo, dataLocacao));
	}

	public void encerrarLocacoes(Cliente novoCliente, Veiculo novoVeiculo, LocalDate dataLocacao, Float kmAtual) {
		Locacao novaLocacao = null;
		for (Locacao locacao: dadosLocacoes.getLocacoes()) {
			if (novoCliente.getDocumento().equals(locacao.getCliente().getDocumento()) && novoVeiculo.getPlaca().equals(locacao.getVeiculo().getPlaca()) && dataLocacao.equals(locacao.getDataLocacao())) {
				novaLocacao = locacao;
				break;
			}
		} 
		if (novaLocacao != null) {
			novaLocacao.encerrar(kmAtual);
			System.out.println(kmAtual);
			System.out.println(novaLocacao.getDataEntrega());
			System.out.println(novaLocacao.getValor());					
		}
	}

	public void listarLocacoes() {

	}

}
