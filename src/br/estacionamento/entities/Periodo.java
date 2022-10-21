package br.estacionamento.entities;

import java.util.Date;

public class Periodo {

	private Date entrada;
	private Date saida;
	
	
	
	public Periodo(Date entrada) {
		super();
		this.entrada = entrada;
	}
	
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}

	@Override
	public String toString() {
		return "Periodo [entrada= " + entrada + ", saida= " + saida + "]";
	}
	
	
	
	
}
