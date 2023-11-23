package Dados.Equipe.Equipamentos;

import Dados.Equipe.calculoCusto;

public class Barco extends Equipamento implements calculoCusto {
	private int capacidade;

	public Barco(int id, String nome, double custoDia) {
		super(id, nome, custoDia);
		this.capacidade = capacidade;

	}

	@Override
	public double calculaCusto() {
		return 0;
	}
}
