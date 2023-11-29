package Cadastro;

import Dados.Atendimento.Atendimento;
import Dados.Atendimento.Eventos.Ciclone;
import Dados.Atendimento.Eventos.Evento;
import Dados.Atendimento.Eventos.Seca;
import Dados.Atendimento.Eventos.Terremoto;
import Dados.Atendimento.Status;
import Dados.Equipe.Equipamentos.Barco;
import Dados.Equipe.Equipamentos.CaminhaoTanque;
import Dados.Equipe.Equipamentos.Equipamento;
import Dados.Equipe.Equipamentos.Escavadeira;
import Dados.Equipe.Equipe;

import java.util.ArrayList;

public class Cadastro {
    //objetos das classes de cadastro
    CadastraEventos cadEvent = new CadastraEventos();
    cadastraEquipamento cadEquip = new cadastraEquipamento();
    CadastraEquipes cadEquipe = new CadastraEquipes();
    cadastraAtendimento cadAtend = new cadastraAtendimento();

    //cadastro dos eventos que retornam uma String, percebi que dava pra ser feito direto na sua própria classe, mas mudar depois seria trabalho
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

    //métodos para mostrar os dados correspondentes
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
    public String mostrarEquipamentos(){
        ArrayList<Equipamento> equipamentos = cadEquip.getEquipamentos();
        System.out.println(equipamentos.size());
        if (equipamentos !=null && !equipamentos.isEmpty()){
            StringBuilder equipamentosStr = new StringBuilder();
            for (Equipamento equipamento : equipamentos){
                equipamentosStr.append(equipamento.toString()).append("\n");
            }
            System.out.println(equipamentosStr);
            return equipamentosStr.toString();
        }
        return "Nenhum equipamento cadastrado";
    }
    public String mostrarEquipes(){
        ArrayList<Equipe> equipes = cadEquipe.getEquipes();
        System.out.println("equipe"+equipes.size());
        if (equipes !=null && !equipes.isEmpty()){
            StringBuilder equipesStr = new StringBuilder();
            for (Equipe equipe : equipes){
                equipesStr.append(equipe.toString()).append("\n");
            }
            System.out.println(equipesStr);
            return equipesStr.toString();
        }
        return "Nenhuma equipe cadastrada";
    }
    public String mostrarAtendimentos(){
        ArrayList<Atendimento> atendimentos = cadAtend.getAtendimentos();
        if (atendimentos != null && !atendimentos.isEmpty()){
            StringBuilder eventosStr = new StringBuilder();
            for (Atendimento atendimento:atendimentos) {
                eventosStr.append(atendimento.toString()).append("\n");
            }
            return eventosStr.toString();
        }
        return "Nenhum atendimento cadastrado";
    }
    public String mostrarTodosDados() {
        StringBuilder todosDadosStr = new StringBuilder();
        todosDadosStr.append(mostrarEventos()).append("\n")
                .append(mostrarEquipamentos()).append("\n")
                .append(mostrarEquipes()).append("\n")
                .append(mostrarAtendimentos());
        System.out.println(mostrarAtendimentos());
        System.out.println(mostrarEquipes());
        System.out.println(mostrarEquipes());
        return todosDadosStr.toString();
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
    public String cadastroAtendimento(String evento, int cod, String data, int duracao, Status status) {
        Evento event = null;
        ArrayList<Evento> eventos = cadEvent.todosEventos();
        for (Evento e : eventos) {
            if (e.getCodigo().equals(evento)) {
                event = e;
            }
        }
        Atendimento atendimento = new Atendimento(event, cod, data, duracao, status);
        if (cadAtend.addAtendimento(atendimento)) {
            return "Sucesso";
        }
        return "Erro ao cadastrar o novo atendimento";
    }

    public String cadastraEquipe(String codinome, int quantidade, double latitude, double longitude, ArrayList<Equipamento> equipamentos){
        ArrayList<Equipe> equipes = cadEquipe.getEquipes();
        Equipe equipe = new Equipe(codinome, quantidade, latitude, longitude, equipamentos);
        if (cadEquipe.addEquipe(equipe)){
            return "Equipe cadastrada";
        }
        return "Erro ao cadastrar";
    }

}

