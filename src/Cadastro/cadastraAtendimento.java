package Cadastro;

import Dados.Atendimento.Atendimento;
import Dados.Atendimento.Eventos.Ciclone;
import Dados.Atendimento.Eventos.Evento;
import Dados.Atendimento.Eventos.Seca;
import Dados.Atendimento.Eventos.Terremoto;

import java.util.ArrayList;
import java.util.Queue;

public class cadastraAtendimento {
    private ArrayList<Atendimento> atendimentos = new ArrayList<>();

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public boolean addAtendimento(Atendimento novoAtendimento) {
        for(Atendimento a : atendimentos){
            if (a.getCodigo() == novoAtendimento.getCodigo()){
                return false;
            }
        }
        return atendimentos.add(novoAtendimento);
    }
}


