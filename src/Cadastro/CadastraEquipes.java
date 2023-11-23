package Cadastro;

import Dados.Equipe.Equipe;

import java.util.ArrayList;

public class CadastraEquipes {
    private ArrayList<Equipe> equipes;

    public CadastraEquipes(){
        equipes = new ArrayList<>();
    }

    public boolean addEquipe(Equipe novaEquipe){
        for (Equipe e : equipes){
            if (novaEquipe.getCodinome().equalsIgnoreCase(e.getCodinome())){
                return false;
            }
        }
        return equipes.add(novaEquipe);
    }

    public Equipe buscaPorCodinome(String codinome){
        for (Equipe e : equipes){
            if(e.getCodinome().equals(codinome));
            return e;
        }
        return null;
    }

    public ArrayList getEquipes(){
        return equipes;
    }
}
