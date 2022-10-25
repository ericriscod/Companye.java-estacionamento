package br.estacionamento.entities;

public class Pessoa {
	
	private String nome;
	private String documento;
	private String telefone;
	
	public Pessoa(String nome, String documento, String telefone) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public String getDocumento() {
		return documento;
	}
	public String getTelefone() {
		return telefone;
	}
	
	@Override
	public String toString() {
		return nome +  "; Documento= " + documento + "; Telefone= " + telefone + ".";
	}
}
