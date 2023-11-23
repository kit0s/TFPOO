package Dados.Atendimento.Eventos;

public class Ciclone extends Evento {
	private double velocidade;
	private double precipitacao;


	public Ciclone(String codigo, String data, double latitude, double longitude) {
		super(codigo, data, latitude, longitude);
		this.velocidade = velocidade;
		this.precipitacao = precipitacao;

	}


}
