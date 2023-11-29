package Dados.Atendimento;

import Dados.Atendimento.Eventos.Evento;
import Dados.Equipe.Equipe;

public class Atendimento {
	private Evento evento;
	private int cod;
	private String dataInicio;
	private int duracao;
	private Status status;  // Alteração aqui
	private Equipe equipe;

	public Atendimento(Evento evento, int cod, String dataInicio, int duracao, Status status) {  // Alteração aqui
		this.evento = evento;
		this.cod = cod;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.status = status;

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
	public String toString() {
		return String.format("""
                Evento: %s
                Data: %s
                duracao: %d
                Status: %s
                """, evento.getCodigo(), dataInicio, duracao, status.toString());

	}
}
