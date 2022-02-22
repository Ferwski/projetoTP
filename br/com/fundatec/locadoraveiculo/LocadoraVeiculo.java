package br.com.fundatec.locadoraveiculo;

import java.util.Scanner;

import br.com.fundatec.locadoraveiculo.tela.MenuPrincipal;

public class LocadoraVeiculo {
	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		MenuPrincipal menu = new MenuPrincipal();
		menu.imprimirMenu();
		System.out.println("Encerrado Locadora de Veículos.");
	}
}
