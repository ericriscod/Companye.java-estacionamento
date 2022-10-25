package br.estacionamento.application;

import java.util.Locale;
import java.util.Scanner;

import br.estacionamento.model.Estacionamento;

public class Application {

	public static void main(String[] args) {

		Estacionamento estacionamento;
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		
		System.out.println("Estacionamento do Tio");

		// Limitar quantidade de vagas.

		estacionamento = new Estacionamento(25);
		System.out.println("\nTotal de vagas: " + estacionamento.getVagasTotal());
		String i = "";

		while (!i.equalsIgnoreCase("n")) {
			System.out.println("\n-------------------------<Menu>-------------------------------");
			System.out.println(" 1) Vagas disponiveis.     6) Liberar vaga."); //28
			System.out.println(" 2) Listar vagas.          7) Historico.");
			System.out.println(" 3) Buscar por placa.      8) Valor caixa.");
			System.out.println(" 4) Buscar por vaga.       9) Valor/hora.");    
			System.out.println(" 5) Estacionar.");
			System.out.println("---------------------------------------------------------------\n");
			System.out.print("Escolha:");
			estacionamento.opcaoMenu(sc.nextInt());

			System.out.print("\nPARA SAIR DO PROGRAMA APERTE (N): ");
			i = sc.next();
		}
		System.out.println("\nPrograma finalizado!\n\nDesenvolvido por Ericris Rossato.");
		estacionamento.closeScanner();
		sc.close();
	}
}
