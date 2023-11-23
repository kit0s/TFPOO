package Cadastro;

import Dados.Atendimento.Atendimento;

import java.util.ArrayList;
import java.util.Queue;

public class cadastraAtendimento {
    private Queue<Atendimento> atendimentos;

    private boolean addAtendimento(Atendimento novoAtendimento) {
        for(Atendimento a : atendimentos){
            if (a.getCodigo() == novoAtendimento.getCodigo()){
                return false;
            }
        }
        return atendimentos.add(novoAtendimento);
    }
}


