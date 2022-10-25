package br.estacionamento.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.estacionamento.entities.Carro;
import br.estacionamento.entities.Pessoa;
import br.estacionamento.entities.Vaga;

public class Estacionamento {

	private Integer vagasTotal;
	private Double valorCaixa;
	private Double valorHora;
	private Carro carro;
	private Pessoa condutor;
	private Vaga vaga;
	private List<Carro> lista;
	private List<Carro> historico;
	private Integer numVaga = 1;

	private Scanner scan = null;

	public Estacionamento(Integer vagasTotal) {
		super();
		valorHora = 10.0;
		valorCaixa = 0.0;
		lista = new ArrayList<>();
		historico = new ArrayList<>();
		scan = new Scanner(System.in);
		this.vagasTotal = vagasTotal;
	}

	//

	public Carro getCarro() {
		return carro;
	}

	public Integer getVagasTotal() {
		return vagasTotal;
	}

	public Double getValorCaixa() {
		System.out.print("\nValor do caixa: " + String.format("%.2f", valorCaixa) + "\n");
		return valorCaixa;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public List<Carro> getLista() {
		return lista;
	}

	//

	private void vagasDisponiveis() {
		if (verificarLista()) {
			System.out.print("\nVagas disponiveis: " + vagasTotal + "\n");
		} else {
			int disponivel = getVagasTotal() - lista.size();
			System.out.println("\nVagas disponiveis: " + disponivel);
		}
	}

	private void listarVagas() {
		System.out.println("\nListar vagas: ");

		if (verificarLista()) {
			System.out.println("Sem carros para listar!");
		} else {
			for (Carro list : lista) {
				System.out.println(list + "\n");
			}
		}
	}

	private void localizarVaga() {
		System.out.print("\nInforme a placa do carro: ");
		String placa = scan.next();
		Boolean isTrue = true;

		if (verificarLista()) {
			System.out.println("Estacionamento vazio!");
			isTrue = false;
		} else if (lista.size() >= 0) {
			for (Carro list : lista) {
				if (placa.equals(list.getPlaca())) {
					System.out.println("Vaga(" + list.getVaga().getNumVaga() + ")");
					isTrue = false;
				}
			}
		}
		if (isTrue) {
			System.out.println("Carro nao localizado!");
		}
	}

	private void localizarCarro() {
		System.out.print("\nInforme a vaga: ");
		Integer vaga = scan.nextInt();
		Boolean isTrue = true;

		if (verificarLista()) {
			System.out.println("Estacionamento vazio!");
			isTrue = false;
		} else if (lista.size() >= 0) {
			for (Carro list : lista) {
				if (vaga.equals(list.getVaga().getNumVaga())) {
					System.out.println(list);
					isTrue = false;
				}
			}
		}
		if (isTrue) {
			System.out.println("Carro nao localizado!");
		}
	}

	private void estacionar() {

		if (!(lista.size() >= vagasTotal)) {
			vaga = new Vaga();
			vaga.setEntrada(LocalDateTime.now());
			vaga.setSaida(null);
			vaga.setNumVaga(numVaga);

			System.out.println("\nPara estacionar sera necessario algumas informacoes do veiculo: ");

			System.out.print("Cor: ");
			String cor = scan.next();

			System.out.print("Modelo: ");
			String modelo = scan.next();

			System.out.print("Placa: ");
			String placa = scan.next();

			System.out.println("\nCondutor.");

			System.out.print("Nome completo: ");
			scan.nextLine();
			String nome = scan.nextLine();

			System.out.print("Documento: ");
			String documento = scan.next();

			System.out.print("Telefone: ");
			String telefone = scan.next();

			condutor = new Pessoa(nome, documento, telefone);
			carro = new Carro(cor, modelo, placa, condutor, vaga);

			lista.add(carro);

			numVaga++;

			System.out.println("\nVeiculo pronto, estacionado!");
		} else {
			System.out.println("Todas vagas ocupadas!");
		}
	}

	private void liberarVaga() {
		System.out.print("\nInforme a placa do carro:");
		String placa = scan.next();

		Boolean isTrue = false;

		for (Carro list : lista) {

			if (list.getPlaca().equalsIgnoreCase(placa)) {
				list.getVaga().setSaida(LocalDateTime.now());
				valorCaixa += valorHora(list);
				historico.add(list);
			}
		}

		isTrue = lista.removeIf(c -> (c.getPlaca().equalsIgnoreCase(placa)));

		if (isTrue) {
			System.out.println("Vaga liberada! Registrada no historico.");

		} else {
			System.out.println("Carro nao localizado.");
		}
	}

	private Double valorHora(Carro carro) {

		Integer entradaHora = carro.getVaga().getEntrada().getHour();
		Integer saidaHora = carro.getVaga().getSaida().getHour();
		Integer saidaMinut = carro.getVaga().getSaida().getMinute();

		Duration d = Duration.between(carro.getVaga().getSaida(), carro.getVaga().getEntrada());

		if (entradaHora == saidaHora) {
			return valorHora;
		} else if (entradaHora < saidaHora & saidaMinut > 0) {
			return (d.toHours() + 1) * valorHora;
		} else {

			return d.toHours() * valorHora;
		}
	}

	private void valorHora() {
		System.out.println("\nValor/hora: " + valorHora);
		System.out.print("Deseja alterar o valor (s/n)?");
		String opcao = scan.next();

		if ((opcao.equalsIgnoreCase("s"))) {
			System.out.print("\nDigite o novo valor: ");
			Double novoValor = scan.nextDouble();

			valorHora = novoValor;
			System.out.println("Valor atualizado!");
		}
	}

	private void historico() {
		System.out.println("\nHistorico: ");

		if (verificarHistorico()) {
			System.out.println("Sem historico no momento!");
		} else {
			for (Carro list : historico) {
				System.out.println(list + "\n");
			}
		}
	}

	public void opcaoMenu(Integer menu) {

		switch (menu) {
		case 1: {
			vagasDisponiveis();
			break;
		}

		case 2: {
			listarVagas();
			break;
		}
		case 3: {
			localizarVaga();
			break;
		}
		case 4: {
			localizarCarro();
			break;
		}
		case 5: {
			estacionar();
			break;
		}

		case 6: {
			liberarVaga();
			break;
		}
		case 7: {
			historico();
			break;
		}
		case 8: {
			getValorCaixa();
			break;
		}
		case 9: {
			valorHora();
			;
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + menu);
		}
	}

	private Boolean verificarLista() {
		if (lista.isEmpty()) {
			return true;
		}
		return false;
	}

	private Boolean verificarHistorico() {
		if (historico.isEmpty()) {
			return true;
		}
		return false;
	}

	public void closeScanner() {
		if (!(scan == null)) {
			scan.close();
		}
	}
}
