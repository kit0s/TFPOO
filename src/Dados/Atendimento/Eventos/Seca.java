package Dados.Atendimento.Eventos;

public class Seca extends Evento {
	private int estiagem;

	public Seca(String codigo, String data, double latitude, double longitude) {
		super(codigo, data, latitude, longitude);
		this.estiagem = estiagem;
	}
}
