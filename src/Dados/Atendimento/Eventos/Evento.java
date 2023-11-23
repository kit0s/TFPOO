package Dados.Atendimento.Eventos;

public abstract class Evento {
	private String codigo;
	private String data;
	private double latitude;
	private double longitude;
	private int duracao;

	public Evento(String codigo, String data, double latitude, double longitude, int duracao){
		this.codigo = codigo;
		this.data = data;
		this.latitude = latitude;
		this.longitude = longitude;
		this.duracao = duracao;
	}

	public int getDuracao(){
		return duracao;
	}


}
