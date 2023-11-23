package Dados.Equipe.Equipamentos;

import Dados.Equipe.calculoCusto;

public class CaminhaoTanque extends Equipamento implements calculoCusto {
	private double capacidade;

	public CaminhaoTanque(int id, String nome, double custoDia, double capacidade) {
		super(id, nome, custoDia);
		this.capacidade = capacidade;
	}

	@Override
	public double calculaCusto() {
		return 0;
	}
}
