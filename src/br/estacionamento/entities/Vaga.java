package br.estacionamento.entities;

import java.time.LocalDateTime;

public class Vaga {

	private LocalDateTime entrada;
	private LocalDateTime saida;
	private Integer vaga;

	public Vaga() {
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime date) {
		this.entrada = date;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public Integer getNumVaga() {
		return vaga;
	}

	public void setNumVaga(Integer vaga) {
		this.vaga = vaga;
	}

	@Override
	public String toString() {
		return "Periodo [entrada= " + entrada + ", saida= " + saida + "]";
	}
}
