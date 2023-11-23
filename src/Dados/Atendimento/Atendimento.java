package Dados.Atendimento;

import Dados.Equipe.Equipe;

public class Atendimento {
	private int cod;
	private String dataInicio;
	private int duracao;
	private Status status;  // Alteração aqui
	private Equipe equipe;

	public Atendimento(int cod, String dataInicio, int duracao, Status status, Equipe equipe) {  // Alteração aqui
		this.cod = cod;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.status = status;
		this.equipe = equipe;
	}

	public int getCodigo() {  // Nome alterado de getCodigo para getCod
		return cod;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double calculaCusto() {
		// Implemente a lógica de cálculo do custo do atendimento aqui
		return 0;
	}
}
