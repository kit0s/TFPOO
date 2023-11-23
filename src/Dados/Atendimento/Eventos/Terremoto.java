package Dados.Atendimento.Eventos;

public class Terremoto extends Evento {

	private double magnitude;

	public Terremoto(String codigo, String data, double latitude, double longitude) {
		super(codigo, data, latitude, longitude);
		this.magnitude = magnitude;
	}
}
