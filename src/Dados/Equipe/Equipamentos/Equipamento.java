package Dados.Equipe.Equipamentos;

public abstract class Equipamento {
	private int id;
	private String nome;
	private double custoDia;

	public Equipamento(int id, String nome, double custoDia) {
		this.id = id;
		this.nome = nome;
		this.custoDia = custoDia;
	}



}
