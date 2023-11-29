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

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getCustoDia() {
		return custoDia;
	}
	@Override
	public String toString() {
		return String.format("""
                Id: %d
                Nome: %s
                Custo ao dia: %.2f
                """, id, nome, custoDia);

	}
}
