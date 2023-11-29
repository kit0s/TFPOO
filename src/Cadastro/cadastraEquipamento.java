package Cadastro;

import Dados.Equipe.Equipamentos.*;

import java.util.ArrayList;

public class cadastraEquipamento {
    private Barco barco;
    private CaminhaoTanque caminhaoTanque;
    private Escavadeira escavadeira;

    private  ArrayList<Equipamento> equipamentos;
    public cadastraEquipamento(){equipamentos = new ArrayList<Equipamento>();}
    public boolean addEquip(Equipamento equipamento){
        if (consultaPorCodigo(equipamento.getId()) == null){
            equipamentos.add(equipamento);
            return true;
        }
        return false;
    }
public Equipamento consultaPorCodigo(int id){
    for(Equipamento e : equipamentos){
        if (e.getId() == id){
            if (e instanceof Barco){
                return (Barco) e;
            }
            if (e instanceof CaminhaoTanque){
                return (CaminhaoTanque) e;
            }
            if (e instanceof Escavadeira){
                return (Escavadeira) e;
            }
        }
    }
    return null;
}

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }
}
