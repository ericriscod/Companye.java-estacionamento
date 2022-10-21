package br.estacionamento.entities;

public class Carro {
	
	private String cor;
	private String modelo;
	private String placa;
	private Pessoa condutor;
	private Periodo data;
	

	
	public Carro(String cor, String modelo, String placa, Pessoa condutor) {
		super();
		this.cor = cor;
		this.modelo = modelo;
		this.placa = placa;
		this.condutor = condutor;
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
	public Periodo getData() {
		return data;
	}
	public void setData(Periodo data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Carro [cor= " + cor + ", modelo= " + modelo + ", placa= " + placa + "\n Condutor= " + condutor + ", data= "
				+ data + "]";
	}
	
	
	

}
