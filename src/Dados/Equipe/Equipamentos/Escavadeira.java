package Dados.Equipe.Equipamentos;

import Dados.Equipe.calculoCusto;

public class Escavadeira extends Equipamento implements calculoCusto {
	private String combustivel;
	private double carga;

	public Escavadeira(int id, String nome, double custoDia, String combustivel, double carga) {
		super(id, nome, custoDia);
		this.combustivel = combustivel;
		this.carga = carga;

	}

	@Override
	public double calculaCusto() {
		return 0;

	}
}
