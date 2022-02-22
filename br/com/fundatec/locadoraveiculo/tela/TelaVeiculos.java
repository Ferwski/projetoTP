package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.fundatec.locadoraveiculo.bancodedados.DadosVeiculos;
import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

public class TelaVeiculos {

	private static TelaVeiculos instancia;
	private Scanner console = new Scanner(System.in);
	private DadosVeiculos dadosVeiculos = DadosVeiculos.criar();

	public TelaVeiculos() {
	}

	private void desenharMenu() {
		System.out.println(" ______________________________________");
		System.out.println("|           MENU DE VEÍCULOS           |");
		System.out.println("|______________________________________|");
		System.out.println("|    Digite uma opção abaixo:          |");
		System.out.println("|  [1] - Cadastrar novo veículo        |");
		System.out.println("|  [2] - Listar veículos               |");
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
				System.out.println("Informe a placa do carro: ");
				String placa = console.next();
				System.out.println("Informe a marca do carro:");
				String marca = console.next();
				System.out.println("Informe o modelo do veiculo:");
				String modelo = console.next();
				System.out.println("Informe a quilometragem:");
				Float quilometragem = console.nextFloat();
				System.out.println("Informe o valor por quilometro rodado");
				Double valorKmRodado = console.nextDouble();
				System.out.println("Informe o valor da diária:");
				Double valorDiaria = console.nextDouble();
				System.out.println("Informe o tipo de carro (CARRO, HATCH, SEDAN, SUV, PICKUP):");
				var tipoVeiculo = TipoVeiculo.valueOf(console.next());
				this.cadastrarVeiculos(placa, marca, modelo, tipoVeiculo, quilometragem, valorKmRodado, valorDiaria);
				break;
			case 2:
				System.out.println("Lista de veiculos");
				this.listarVeiculos();

			case 0:
				System.out.println("Retornando a tela principal...");
				return;

			default:
				System.out.println("Opção inválida, digite novamente.");
				break;
			}
		} while (true);
	}

	public static TelaVeiculos criar() {
		if (instancia == null) {
			instancia = new TelaVeiculos();
		}
		return instancia;
	}

	public void cadastrarVeiculos(String placa, String marca, String modelo, TipoVeiculo tipoVeiculo, float quilometragem, double valorKmRodado,
			double valorDiaria) {
		dadosVeiculos.adicionar(new Veiculo(placa, marca, modelo, tipoVeiculo, quilometragem, valorKmRodado, valorDiaria));
	}

	public void listarVeiculos() {
		for (Veiculo elemento : dadosVeiculos.getVeiculos()) {
			System.out.println("Placa: " + elemento.getPlaca() + ", marca: " + elemento.getMarca() + ", modelo: "
					+ elemento.getModelo() + ", Km: " + elemento.getQuilometragem() + ", Km Rodado: "
					+ elemento.getValorKmRodado() + ", Valor da diária: " + elemento.getValorDiaria()
					+ "e tipo do carro: " + elemento.getTipoCarro());
		}
	}
}
