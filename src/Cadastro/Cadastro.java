package Cadastro;

import Dados.Atendimento.Eventos.Ciclone;
import Dados.Atendimento.Eventos.Evento;
import Dados.Atendimento.Eventos.Seca;
import Dados.Atendimento.Eventos.Terremoto;
import Dados.Equipe.Equipamentos.Barco;
import Dados.Equipe.Equipamentos.CaminhaoTanque;
import Dados.Equipe.Equipamentos.Equipamento;
import Dados.Equipe.Equipamentos.Escavadeira;

import java.util.ArrayList;

public class Cadastro {
    CadastraEventos cadEvent = new CadastraEventos();
    cadastraEquipamento cadEquip = new cadastraEquipamento();
    public String cadT(String codigo, String data, double longitude, double latitude, double magnitude){
        Evento evento = new Terremoto(codigo, data, longitude, latitude, magnitude);
        if (cadEvent.addEvento(evento)){
            cadEvent.ordenarEventos();
            return "Terremoto cadastrado com sucesso!";
        } else {
            return "Erro: código do evento já cadastrado!";
        }
    }
    public String cadC(String codigo, String data, double longitude, double latitude, double velocidade, double preciptacao){
        Evento evento = new Ciclone(codigo, data, longitude, latitude, velocidade, preciptacao);
        if (cadEvent.addEvento(evento)){
            cadEvent.ordenarEventos();
            return "Ciclone cadastrado com sucesso!";
        } else {
            return "Erro: código do evento já cadastrado!";
        }
    }
    public String cadS(String codigo, String data, double longitude, double latitude, int seca){
        Evento evento = new Seca(codigo, data, longitude, latitude, seca);
        if (cadEvent.addEvento(evento)){
            cadEvent.ordenarEventos();
            return "Seca cadastrada com sucesso!";
        } else {
            return "Erro: código do evento já cadastrado!";
        }
    }
    public String mostrarEventos(){
        ArrayList<Evento> eventos = cadEvent.todosEventos();
        if (eventos != null && !eventos.isEmpty()){
            StringBuilder eventosStr = new StringBuilder();
            for (Evento evento: eventos) {
                eventosStr.append(evento.toString()).append("\n");
            }
            return eventosStr.toString();
        }
        return "Nenhum evento cadastrado";
    }
    public String cadCaminhao(int id, String nome,double custoDia, double capacidade){
        Equipamento equipamento = new CaminhaoTanque(id, nome, custoDia, capacidade);
        if (cadEquip.addEquip(equipamento)){
            return "cadastrado com sucesso";
        } else {
            return "Erro: id do equipamento já cadastrado!";
        }
    }
    public String cadBarco(int id, String nome,double custoDia, int capacidade){
        Equipamento equipamento = new Barco(id, nome, custoDia, capacidade);
        if (cadEquip.addEquip(equipamento)){
            return "cadastrado com sucesso";
        } else {
            return "Erro: id do equipamento já cadastrado!";
        }
    }
    public String cadEscavadeira(int id, String nome,double custoDia, String combustivel, double carga){
        Equipamento equipamento = new Escavadeira(id, nome, custoDia, combustivel, carga);
        if (cadEquip.addEquip(equipamento)){
            return "cadastrado com sucesso";
        } else {
            return "Erro: id do equipamento já cadastrado!";
        }
    }
}
