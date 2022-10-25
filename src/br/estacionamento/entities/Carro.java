package br.estacionamento.entities;

import java.time.format.DateTimeFormatter;

public class Carro {

	private String cor;
	private String modelo;
	private String placa;
	private Pessoa condutor;
	private Vaga vaga;

	public Carro(String cor, String modelo, String placa, Pessoa condutor, Vaga vaga) {
		super();
		this.cor = cor;
		this.modelo = modelo;
		this.placa = placa;
		this.condutor = condutor;
		this.vaga = vaga;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Pessoa getCondutor() {
		return condutor;
	}

	public void setCondutor(Pessoa condutor) {
		this.condutor = condutor;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		if (vaga.getSaida() == null) {
			return "Vaga(" + vaga.getNumVaga() + "):\n{Carro= " + modelo + "; Cor= " + cor + "; Placa= " + placa
					+ ".\nCondutor= " + condutor + "\nEntrada= " + dtf.format(vaga.getEntrada()) + "}";
		}
		return "Vaga(" + vaga.getNumVaga() + "):\n{Carro= " + modelo + "; Cor= " + cor + "; Placa= " + placa
				+ ".\nCondutor= " + condutor + "\nEntrada= " + dtf.format(vaga.getEntrada()) + "; Saida= "
				+ dtf.format(vaga.getSaida()) + "}";
	}
}
