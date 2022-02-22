package br.com.fundatec.locadoraveiculo.tela;

import java.util.Scanner;

import br.com.fundatec.locadoraveiculo.bancodedados.CriacaoBaseDados;

public class MenuPrincipal {
	Scanner console = new Scanner(System.in);

	public MenuPrincipal() {
		CriacaoBaseDados.inicializarBase();
	}

	private void desenharMenu() {
		System.out.println(" ______________________________________");
		System.out.println("|           MENU DE PRINCIPAL          |");
		System.out.println("|______________________________________|");
		System.out.println("|    Digite uma op��o abaixo:          |");
		System.out.println("|  [1] - Ir para Tela de Ve�culos      |");
		System.out.println("|  [2] - Ir para Tela de Clientes      |");
		System.out.println("|  [3] - Ir para Tela de Loca��es      |");
		System.out.println("|  [0] - Encerrar o programa	       |");
		System.out.println("+--------------------------------------+");
	}

	public void imprimirMenu() {
		do {
			this.desenharMenu();
			int opcao = console.nextInt();

			switch (opcao) {
			case 1:
				TelaVeiculos telaVeiculo = new TelaVeiculos();
				telaVeiculo.imprimirMenu();
				break;
			case 2:
				TelaCliente telaCliente = new TelaCliente();
				telaCliente.imprimirMenu();
				break;
			case 3:
				TelaLocacao telaLocacao = new TelaLocacao();
				telaLocacao.imprimirMenu();
				break;
			case 0:
				System.out.println("Sistema encerrando...");
				break;
			default:
				System.out.println("Op��o inv�lida, digite novamente.");
				break;
			}
		} while (true);
	}
}
