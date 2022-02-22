package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.fundatec.locadoraveiculo.bancodedados.DadosClientes;
import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Endereco;

public class TelaCliente {

	private Scanner console = new Scanner(System.in);
	private DadosClientes dadosClientes = DadosClientes.criar();
	
	public TelaCliente() {
		
	}

	private void desenharMenu() {
		System.out.println(" ______________________________________");
		System.out.println("|           MENU DE CLIENTES           |");
		System.out.println("|______________________________________|");
		System.out.println("|    Digite uma opção abaixo:          |");
		System.out.println("|  [1] - Cadastrar cliente (PF ou PJ)  |");
		System.out.println("|  [2] - Listar clientes               |");
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
			switch (opcao) {
			case 1:
				System.out.println("Informe o nome do cliente:");
				console.nextLine();
				String nome = console.nextLine();
				System.out.println("Qual a raz�o social do cliente?");
				System.out.println("FISICA ou JURIDICA? Digite exatamente como informado acima ");
				var tipoPessoa = TipoPessoa.valueOf(console.next());
				String razaoSocial;
				if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {
					System.out.println("Informe a sua razao social");
					console.nextLine();
					razaoSocial = console.nextLine();
				} else {
					razaoSocial = "N�o h�";
				}
				System.out.println("Informe seu tipo do seu documento:");
				System.out.println("CPF, CNPJ ou RG?");
				var tipoDocumento = TipoDocumento.valueOf(console.next());
				System.out.println("Informe o numero do seu documento:");
				Long documento = console.nextLong();
				System.out.println("Informe o numero da casa:");
				int numeroCasa = console.nextInt();
				console.nextLine();
				System.out.println("Informe o endere�o do cliente:");
				String logradouro = console.nextLine();
				System.out.println("Informe o complemento:");
				String complemento = console.nextLine();
				System.out.println("Informe o bairro:");
				String bairro = console.nextLine();
				System.out.println("Informe a cidade:");
				String cidade = console.nextLine();
				System.out.println("Informe a UF:");
				String uf = console.next().toUpperCase();
				System.out.println("Informe o CEP:");
				int cep = console.nextInt();
				Endereco endereco = new Endereco(logradouro, numeroCasa, complemento, bairro, cidade, uf, cep);
				this.cadastrarClientes(nome, tipoPessoa, tipoDocumento, documento, razaoSocial, endereco);
				break;
			case 2:
				System.out.println("Lista de clientes:");
				this.listarClientes();
			case 0:
				System.out.println("Retornando a tela principal...");
				return;

			default:
				System.out.println("Op��o inv�lida, digite novamente.");
				break;
			}
		} while (true);
	}

	public void cadastrarClientes(String nomeCliente, TipoPessoa tipoPessoa, TipoDocumento tipoDocumento,
			Long documento, String razaoSocial, Endereco endereco) {
		dadosClientes.adicionar(new Cliente(nomeCliente, tipoPessoa, tipoDocumento, documento, razaoSocial, endereco));
	}

	public void listarClientes() {
		for (Cliente elemento : dadosClientes.getClientes()) {
			System.out.println("Nome: " + elemento.getNome() + ", tipo pessoa: " + elemento.getTipoPessoa() + ", tipo de documento: " + 
		elemento.getTipoDocumento()	+ ", n� documento: " + elemento.getDocumento() + ", raz�o social: " + elemento.getRazaoSocial() +
		", logradouro: " + elemento.getEndereco().getLogradouro() + ", n� endere�o: " + elemento.getEndereco().getNumero() +
		", complemento: " + elemento.getEndereco().getComplemento() + ", bairro: " + elemento.getEndereco().getBairro() + ", cidade: " + 
		elemento.getEndereco().getCidade() + ", UF: " + elemento.getEndereco().getUf() + ", CEP: " + elemento.getEndereco().getCep());
		}
	}
}
