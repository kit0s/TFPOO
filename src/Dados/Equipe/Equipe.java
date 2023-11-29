package Dados.Equipe;
import Dados.Atendimento.Eventos.Evento;
import Dados.Equipe.Equipamentos.Equipamento;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Equipe  {
	private String codinome;
	private int quantidade;
	private double latitude;
	private double longitude;
	private Evento evento;
	private ArrayList<Equipamento> equipamentos;

	public Equipe(String codinome, int quantidade, double latitude, double longitude, Evento evento) {
		this.codinome = codinome;
		this.quantidade = quantidade;
		this.latitude = latitude;
		this.longitude = longitude;
		this.evento = evento;
		this.equipamentos = new ArrayList<>();

	}

	public String getCodinome() {
		return codinome;
	}

	@Override
	public String toString() {
		return "Equipe: " +
				", codinome: " + codinome + '\'' +
				", quantidade: " + quantidade +
				", latitude: " + latitude +
				", longitude: " + longitude;
	}

//	@Override
//	public double calculaCusto() {
//		return e.getDuracao() * 250 * quantidade;
//	}
}
