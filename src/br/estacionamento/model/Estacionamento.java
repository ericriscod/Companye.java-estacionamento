package br.estacionamento.model;

import java.util.List;

import br.estacionamento.entities.Carro;

public class Estacionamento {

		private Integer vagasTotal;
		private Carro carro;
		private List <Carro> lista;
		
		public Estacionamento(Integer vagasTotal) {
			super();
			this.vagasTotal = vagasTotal;
			
		}

		public Carro getCarro() {
			return carro;
		}

		public void setCarro(Carro carro) {
			this.carro = carro;
		}

		public Integer getVagasTotal() {
			return vagasTotal;
		}

		public List<Carro> getLista() {
			return lista;
		}
		
		public Integer vagasDisponiveis() {
			return 0;
		}
		
		public List<Carro> listarVagas(){
			return lista;
		}
		
		public Integer localizarCarro (Carro carro) {
			return 0;
		}
		
		public void estacionar() {
			
		}
		
		public void liberarVaga() {
			
		}
		
		
}
